package com.microservice.account.service.account;

import com.microservice.account.client.CustomerClient;
import com.microservice.account.dto.AccountDto;
import com.microservice.account.dto.CustomerDto;
import com.microservice.account.dto.MsjGenericoDTO;
import com.microservice.account.entities.Account;
import com.microservice.account.http.response.AccountByClientResponse;
import com.microservice.account.mapper.AccountMapper;
import com.microservice.account.persistence.AccountRepository;
import com.netflix.discovery.converters.Auto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements IAccountService{

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CustomerClient customerClient;

    @Autowired
    AccountMapper accountMapper;

    @Override
    public MsjGenericoDTO findAll() {
        MsjGenericoDTO msjGenericoDTO =  new MsjGenericoDTO();
        try{
            List<Account> cuentaList = (List<Account>) accountRepository.findAll();
            msjGenericoDTO.setExitoso(true);
            msjGenericoDTO.setData(cuentaList);
        }
        catch (Exception e){
            e.printStackTrace();
            msjGenericoDTO.setExitoso(false);
        }
        return msjGenericoDTO;
    }

    @Override
    public MsjGenericoDTO findById(Long aLong) {
        MsjGenericoDTO msjGenericoDTO =  new MsjGenericoDTO();
        try{
            Account cuenta = (Account) accountRepository.findAll();
            msjGenericoDTO.setExitoso(true);
            msjGenericoDTO.setData(cuenta);
        }
        catch (Exception e){
            e.printStackTrace();
            msjGenericoDTO.setExitoso(false);
        }
        return msjGenericoDTO;
    }

    @Override
    public MsjGenericoDTO save(AccountDto entity) throws Exception {
        MsjGenericoDTO msjGenericoDTO =  new MsjGenericoDTO();
        try{
            Account cuenta = accountMapper.cuentaDtoToCuenta(entity);
            if (!findAccountByClient(entity.getCustomerId()).equals(null)){
                accountRepository.save(cuenta);
                msjGenericoDTO.setExitoso(true);
            msjGenericoDTO.setData(cuenta);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            msjGenericoDTO.setExitoso(false);
        }
        return msjGenericoDTO;
    }

    @Override
    public MsjGenericoDTO update(AccountDto entity) throws Exception {
        MsjGenericoDTO msjGenericoDTO = new MsjGenericoDTO();
        AccountByClientResponse response = findAccountByClient(entity.getCustomerId());
        try{
            Optional<Account> cuenta = accountRepository.findById(entity.getAccountId());
            if (cuenta.isPresent()){
                Account cuentaUpdate = accountMapper.cuentaDtoToCuenta(entity);
                if (!response.equals(null)){
                    cuentaUpdate.setCliente(response.getClienteId());
                    cuentaUpdate.setAccountBalance(cuenta.get().getAccountBalance());
                    accountRepository.save(cuentaUpdate);
                }
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
    public MsjGenericoDTO deleteById(Long idCuenta) throws Exception {
        MsjGenericoDTO msjGenericoDTO =new MsjGenericoDTO();
        try{
            Optional<Account> cuenta =accountRepository.findById(idCuenta);
            if(cuenta.isPresent()){
                accountRepository.deleteById(idCuenta);
            }
            msjGenericoDTO.setExitoso(true);
        }catch (Exception e){
            e.printStackTrace();
            msjGenericoDTO.setExitoso(false);
        }
        return msjGenericoDTO;
    }

    @Override
    public MsjGenericoDTO validate(AccountDto entity) throws Exception {
        return null;
    }

    @Override
    public AccountByClientResponse findAccountByClient(Long idCLient) {
        CustomerDto customer = (CustomerDto) customerClient.findCustomerById(idCLient);
        return AccountByClientResponse.builder()
                .estado(customer.getEstado())
                .nombreCliente(customer.getNombre())
                .build();
    }

    @Override
    public MsjGenericoDTO filtrarPorFecha(Date fechaInicio, Date fechaFin) {
        return null;
    }
}
