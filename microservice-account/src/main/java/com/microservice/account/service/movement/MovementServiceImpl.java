package com.microservice.account.service.movement;

import com.microservice.account.dto.MovementDto;
import com.microservice.account.dto.MsjGenericoDTO;
import com.microservice.account.entities.Account;
import com.microservice.account.entities.Movements;
import com.microservice.account.http.response.AccountByClientResponse;
import com.microservice.account.mapper.MovementMapper;
import com.microservice.account.persistence.AccountRepository;
import com.microservice.account.persistence.MovementsRepository;
import com.microservice.account.specification.MovementsSpecification;
import com.microservice.account.utility.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MovementServiceImpl implements IMovementService {


    @Autowired
    MovementsRepository movementsRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    MovementMapper movementMapper;
    @Override
    public MsjGenericoDTO findAll() {
        MsjGenericoDTO msjGenericoDTO =new MsjGenericoDTO();
        try{
            List<Movements> clienteMovimientos =(List<Movements>) movementsRepository.findAll();
            msjGenericoDTO.setExitoso(true);
            msjGenericoDTO.setData(clienteMovimientos);
        }catch (Exception e){
            e.printStackTrace();
            msjGenericoDTO.setExitoso(false);
        }
        return msjGenericoDTO;
    }

    @Override
    public MsjGenericoDTO findById(Long aLong) {
        MsjGenericoDTO msjGenericoDTO =  new MsjGenericoDTO();
        try{
            Movements movimiento = (Movements) movementsRepository.findAll();
            msjGenericoDTO.setExitoso(true);
            msjGenericoDTO.setData(movimiento);
        }
        catch (Exception e){
            e.printStackTrace();
            msjGenericoDTO.setExitoso(false);
        }
        return msjGenericoDTO;
    }

    @Override
    public MsjGenericoDTO save(MovementDto entity) throws Exception {
        MsjGenericoDTO msjGenericoDTO =  new MsjGenericoDTO();
        try{
            Movements movimientos = movementMapper.movementDtoToMovement(entity);
            Optional<Account> cuenta = accountRepository.findById(entity.getCuenta().getAccountId());
            if (cuenta.isPresent()){
                Long totalSaldo =cuenta.get().getAccountBalance() + entity.getValor();
                if(totalSaldo < 0){
                    msjGenericoDTO.setExitoso(false);
                    msjGenericoDTO.setMensajeError("Saldo insuficiente para realizar la transaccion");
                }
                cuenta.get().setAccountBalance(totalSaldo);
                accountRepository.save(cuenta.get());
                movimientos.setMovementBalance(totalSaldo);
                movimientos.setMovementType(entity.getValor()< 0? Constantes.TIPO_RETIRO.getValue():Constantes.TIPO_DEPOSITO.getValue());
                movimientos.setCuenta(cuenta.get());
                movementsRepository.save(movimientos);
            }
            msjGenericoDTO.setExitoso(true);
        }
        catch (Exception e){
            e.printStackTrace();
            msjGenericoDTO.setExitoso(false);
        }
        return msjGenericoDTO;
    }

    @Override
    public MsjGenericoDTO update(MovementDto entity) throws Exception {
        MsjGenericoDTO msjGenericoDTO = new MsjGenericoDTO();
        try{
            Optional<Movements> movimientos = movementsRepository.findById(entity.getMovementId());
            if (movimientos.isPresent()){
                Movements movimientosUpdate = movementMapper.movementDtoToMovement(entity);
                Optional<Account> cuenta = accountRepository.findById(entity.getCuenta().getAccountId());
                if(cuenta.isPresent()){
                    movimientosUpdate.setCuenta(cuenta.get());
                    movementsRepository.save(movimientosUpdate);
                }
            }
            msjGenericoDTO.setExitoso(true);
        }catch (Exception e )
        {
            e.printStackTrace();
            msjGenericoDTO.setExitoso(false);
        }
        return msjGenericoDTO;
    }

    @Override
    public MsjGenericoDTO deleteById(Long idMovimiento) throws Exception {
        MsjGenericoDTO msjGenericoDTO =new MsjGenericoDTO();
        try{
            Optional<Movements>movimientos= movementsRepository.findById(idMovimiento);
            if (movimientos.isPresent()){
                movementsRepository.deleteById(idMovimiento);
            }
            msjGenericoDTO.setExitoso(true);
        }catch (Exception e){
            e.printStackTrace();
            msjGenericoDTO.setExitoso(false);
        }
        return msjGenericoDTO;
    }

    @Override
    public MsjGenericoDTO validate(MovementDto entity) throws Exception {
        return null;
    }

    @Override
    public AccountByClientResponse findAccountByClient(Long idCLient) {
        return null;
    }


    @Override
    public MsjGenericoDTO filtrarPorFecha(Date fechaInicio, Date fechaFin) {
        MsjGenericoDTO msjGenericoDTO =new MsjGenericoDTO();
        try{
            Specification<Movements> specification = Specification.where(MovementsSpecification.filtroFechas(fechaInicio,fechaFin));
            List<MovementDto> clienteDtoList = movementsRepository.findAll(specification).stream()
                    .map(movimientos -> movementMapper.movementToMovementDto((Movements) movimientos)).collect(Collectors.toList());
            msjGenericoDTO.setExitoso(true);
            msjGenericoDTO.setData(clienteDtoList);
        }catch (Exception e){
            e.printStackTrace();
            msjGenericoDTO.setData(false);
        }
        return msjGenericoDTO;
    }
}

