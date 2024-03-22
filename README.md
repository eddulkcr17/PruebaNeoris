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
![image](https://github.com/eddulkcr17/PruebaNeoris/assets/67389025/a6d4e9bc-10ac-4875-be37-401ea1c2d4dd)


* cada microservicoo apunta al servicio config donde esta alojada la configuracion para que se levante y los puertos que se utilizaran
![image](https://github.com/eddulkcr17/PruebaNeoris/assets/67389025/c2b5966c-9e0b-40a0-b154-17418693822d)

* los microservicios de Account y de Customer son los que contienen la logica de los endpoints de
  *  api/clientes
  *  api/cuentas
  *  api/movimientos
* Cada microservicio usa la siguiente estructura de carpetas
  ![image](https://github.com/eddulkcr17/PruebaNeoris/assets/67389025/1bafacde-fa57-4e22-886c-62ec5b345265)

  

