
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
  * 2.4.1.1. Se debe ejecutar el siguiente comando para poder obtener el informe.
```bash
gradle clean build jacocoMergedReport
````

![image](https://github.com/user-attachments/assets/d4279b58-7ed3-4145-8702-eec2a37492d2)
* 2.4.1.2. El informe lo encontraremos en la ubicación <br>

![image](https://github.com/user-attachments/assets/c1c011a4-9632-41a5-8030-254dd21f9593)
* 2.4.1.3. Se debe abrir el archivo index.html de la siguiente manera:
![image](https://github.com/user-attachments/assets/9f72dd9e-1f46-4144-b064-3b037db0c1ba)
* 2.4.1.4. El informe se visualizará de la siguiente manera
![image](https://github.com/user-attachments/assets/ed404b4d-d9db-4014-a130-9ba5b3abf0f2)

* 2.4.2 Visualización pruebas de aceptación
* 2.4.2.1. Para una correcta ejecución de las pruebas se debe tener compilando el proyecto.
```bash
gradle bootrun
````
* 2.4.2.2. Se debe abrir en otra ventana IDE la carpeta de acceptationTest que se encuentra dentro del proyecto
![image](https://github.com/user-attachments/assets/d7adf547-61dd-41ef-be9d-b9493ec58832)
                                                                                                        
![image](https://github.com/user-attachments/assets/9415fd7e-65f4-4970-b0d4-332303469f90)
* 2.4.2.3. Cuando se tenga abierta la carpeta se debe buscar el siguiente archivo


   
![image](https://github.com/user-attachments/assets/2007344d-f64f-4174-bb00-d2941ec5be4d)
* 2.4.2.4. Se debe hacer lo siguiente
 

  ![image](https://github.com/user-attachments/assets/8aaf5e4d-aca7-4193-b7c6-329f6bfa7b03)
* 2.4.2.5. En la consola nos indicará si fue exitosa la prueba
  ![image](https://github.com/user-attachments/assets/2e311d5a-6419-4641-973e-9626fb3dcf8e)

* 2.4.3 Visualización pruebas de performance
* 2.4.3.1. Para una correcta ejecución de las pruebas se debe tener compilando el proyecto.
```bash
gradle bootrun
````
* 2.4.3.2 Para la ejecución de las pruebas de performance en ambiente local se requiere tener apache-jmeter (Para este caso se usó apache-jmeter-5.6.3).
* 2.4.3.3 Cuando se tenga abierto JMeter se debe abrir el test plan que tiene el proyecto ubicado en:


![image](https://github.com/user-attachments/assets/50957361-1c18-4008-bf22-dc2cbd0639be)


![image](https://github.com/user-attachments/assets/d88fd678-f9a6-481f-a48c-3e179fc334ca)

* 2.4.3.4 Podremos visualizar el Test plan de la siguiente manera
  ![image](https://github.com/user-attachments/assets/ce0ef315-6785-46ae-9d62-4b1aa9425445)

* 2.4.3.5 Ejecutamos el Test Plan
  
  ![image](https://github.com/user-attachments/assets/6fdb738d-4b8e-4f02-8929-775dfb243e26)
















    
  
