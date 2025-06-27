# Caso práctico de iniciación en IA. 

## 1. Descripción
Microservicio que permite validar la salud del sistema mediante la exposición de un endpoint el cual permite conocer la salud del sistema.

## 2. Health Check
Expone un endpoint que permite verificar el estado de salud del microservicio.

### 2.1 Obtener estado del micro
Esta funcionalidad se encarga de devolver el estado de salud del microservicio al momento que se reciba una solicitud por parte del usuario.
Para lo anterior se puede usar el siguiente curl:

```bash
curl --location 'http://localhost:8080/ms-test-ia/api/checkStatus'
````
* Success Response
```bash
{
    "data": {
        "status": "UP",
        "message": "The system is running"
    },
    "meta": {
        "code": "200",
        "requestDateTime": "2025-06-27 10:35:59"
    }
}
````

* Error Response
```bash
{
    "data": {
        "status": "ERROR",
        "message": "An error occurred while processing the request"
    },
    "meta": {
        "code": "500",
        "requestDateTime": "2025-06-27 10:35:59"
    }
}
````
### 2.3 Compilación y prueba de proyecto
* 2.3.1 Comando de ejecución
Después de tener clonado el proyecto en el equipo se debe ejecutar el siguiente comando en la termine del IDE de preferencia . (Se recomienda IntelliJ IDEA Community).
```bash
gradle bootrun
````
 ![image](https://github.com/user-attachments/assets/7397c9db-e9bc-4880-974c-955e9f089ec1)
 * 2.3.2 Resultado de compilación correcta
Si el proyecto se compiló correctamente en la consola/terminal aparecerá lo siguiente
![image](https://github.com/user-attachments/assets/23447932-ea3c-4999-a7fa-392fbd939665)
Esto nos indicará que el microservicio está listo para ser usado de forma local.
* 2.3.3 Prueba de consumo de endpoint
  ![image](https://github.com/user-attachments/assets/5b671238-9abe-48b8-9571-524304d3d7ee)
### 2.4 Visualización pruebas del microservicio
* 2.4.1 Visualización reporte de pruebas de cobertura
  Se debe ejecutar el siguiente comando para poder obtener el informe.
```bash
gradle clean build jacocoMergedReport
````
![image](https://github.com/user-attachments/assets/d4279b58-7ed3-4145-8702-eec2a37492d2)
El informe lo encontraremos en la ubicación
![image](https://github.com/user-attachments/assets/c1c011a4-9632-41a5-8030-254dd21f9593)
Se debe abrir el archivo index.html de la siguiente manera:
![image](https://github.com/user-attachments/assets/9f72dd9e-1f46-4144-b064-3b037db0c1ba)
El informe se visualizará de la siguiente manera
![image](https://github.com/user-attachments/assets/ed404b4d-d9db-4014-a130-9ba5b3abf0f2)











    
  
