# PruebaNeoris

## Arquitectura utilizada
![image](https://github.com/eddulkcr17/PruebaNeoris/assets/67389025/91c83c7c-a032-44b7-b0bd-dc6bb9bca5b8)
para la solucion de este reto se tomo en cuenta:
* uso de un API Gateway, con esto se garantiza una sola puerta de entrada a nuestro entorno
* el desarrollo de los tres microservicios que se solicitaron en el test
  *  api/clientes
  *  api/cuentas
  *  api/movimientos

* utilizacion de base de datos MySQL, se dividio la logica de los requerimeintos en dos bases de datos con la finalidad de tener un mejor orden y para poder tener un mejor control

* Se utilizao Eureka para poder monitoriar que los servicios esten desplegado correctamente
* Se utilizo un servicio para configuracion para que centralizar la configuracion y que no sea dificil el mantenimiento
* ![image](https://github.com/eddulkcr17/PruebaNeoris/assets/67389025/dac26f39-705e-4e6a-b64e-05dbd5d24daa)

* 

* 
