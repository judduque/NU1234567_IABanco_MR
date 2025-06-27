# Caso práctico de iniciación en IA. 

## 1. Descripción
Microservicio que permite validar la salud del sistema mediante la exposición de un endpoint el cual permite conocer la salud del sistema.

## 2. Health Check
Expone un endpoint que permite verificar el estado de salud del microservicio.

### 2.1 Obtener estado del micro
Esta funcionalidad se encarga de devolver el estado de salud del microservicio al momento que se reciba una solicitud por parte del usuario.

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
 




    
  
