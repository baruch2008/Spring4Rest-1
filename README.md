# Spring4 REST, JAX-RS, Jersey, Spring Data, Elasticsearch Integration Sample

```
-spring 4.1.5
-javax.ws.rs 2.0.1
-jersey-spring3 2.22.1
-spring-data-elasticsearch 1.3.2.RELEASE

Elasticsearch 1.5.2
```

Quick Start
===========

### Elasticsearch configuration

Create Index and 'employees' Type

```
curl -XPOST localhost:9200/resource -d '{
    "settings" : {
        "number_of_shards" : 1
    },
    "mappings" : {
        "employees" : {
            "properties" : {
                "id" : { "type" : "string", "index" : "not_analyzed" },
                "name" : { "type" : "string", "index" : "not_analyzed" },
                "age" : { "type" : "string", "index" : "not_analyzed" },
                "skills" : { 
                    "properties" : {
                        "name" : { "type" : "string", "index" : "not_analyzed" },
                        "experience" : { "type" : "string", "index" : "not_analyzed" }
                    }
                 }
            }
        }
    }
}'
```

Insert Employees documents

```
curl -XPUT 'http://localhost:9200/resource/employees/1' -d '{
    "id" : "01",
    "name" : "Joe",
    "age": "32",
    "skills" : [{"name" : "Java","experience": "10"},{
     "name" : "Oracle","experience": "5"}]    
}'

curl -XPUT 'http://localhost:9200/resource/employees/2' -d '{
    "id" : "02",
    "name" : "John S",
    "age": "32"    
}'

curl -XPUT 'http://localhost:9200/resource/employees/3' -d '{
    "id" : "03",
    "name" : "John P",
    "age": "42"    
}'

curl -XPUT 'http://localhost:9200/resource/employees/4' -d '{
    "id" : "04",
    "name" : "Sam",
    "age": "30"    
}'
```

Mode of use
===========

Create Employee

POST http://localhost:8080/Spring4RestIntegrationSamples/api/employees/

```
{
  "name": "Rossy",
  "age": 27,
  "skills": [
    {
      "name": "REST",
      "experience": 2
    },
    {
      "name": "DB2",
      "experience": 5
    }
  ]
}
```
Get All Employees

GET http://localhost:8080/Spring4RestIntegrationSamples/api/employees/

Filter Employees

by Name

GET http://localhost:8080/Spring4RestIntegrationSamples/api/employees/?name=foo

Get Employee by ID

GET http://localhost:8080/Spring4RestIntegrationSamples/api/employees/01

Delete Employee

DETELE http://localhost:8080/Spring4RestIntegrationSamples/api/employees/05