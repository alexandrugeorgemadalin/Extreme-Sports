#REST-API Extreme Sports
## Description
This is a REST API used for Extreme Sports. It is developed in Java using Spring Framework

# Usage

##Countries
#### Query for all countries
`GET /api/v1/countries`

Example response:

```json
[
  {
    "id": 1,
    "createdAt": "12:27:38 17-Mar-2022",
    "name": "Romania",
    "regions": []
  },
  {
    "id": 2,
    "createdAt": "12:27:38 17-Mar-2022",
    "name": "Austria",
    "regions": []
  }
]
```

#### Query for a specific country
`GET /api/v1/countries/:id`

Exemple response:

```json
{
    "id": 1,
    "createdAt": "12:27:38 17-Mar-2022",
    "name": "Romania",
    "regions": []
}
```

#### Query to add a country
`POST /api/v1/countries`

Exemple request body:
```json
{
    "name": "Romania"
}
```

Exemple response:
```json
{
  "id": 4,
  "createdAt": "12:40:50 17-Mar-2022",
  "name": "SUA",
  "regions": null
}
```

#### Query to update a country
`PUT /api/v1/countries/:id`

Exemple request body:

```json
{
  "name": "Germania"
}
```
Exemple response:
```json
{
  "id": 4,
  "createdAt": "12:40:50 17-Mar-2022",
  "name": "Germania",
  "regions": []
}
```
#### Query to delete a country
`DELETE /api/v1/countries/:id`

#### Query for country with specific name
`GET /api/v1/countries/find?:name`

Exemple query:

`GET /api/v1/countries/find?name=Romania`

Exemple response:

```json
{
  "id": 1,
  "createdAt": "12:27:38 17-Mar-2022",
  "name": "Romania",
  "regions": []
}
```

#### Query for specific countries
`GET /api/v1/countries/find?:countries`

Exemple query:

`GET /api/v1/countries/find?countries=Romania,Austria`

Exemple response:

```json
[
  {
    "id": 1,
    "createdAt": "12:27:38 17-Mar-2022",
    "name": "Romania",
    "regions": []
  },
  {
    "id": 2,
    "createdAt": "12:27:38 17-Mar-2022",
    "name": "Austria",
    "regions": []
  }
]
```

##Regions
#### Query for all regions
`GET /api/v1/regions`

Example response:

```json
[
  {
    "id": 4,
    "createdAt": "06:30:35 18-Mar-2022",
    "name": "Moldova",
    "localities": []
  },
  {
    "id": 5,
    "createdAt": "06:30:59 18-Mar-2022",
    "name": "Transilvania",
    "localities": []
  }
]
```

#### Query for a specific region
`GET /api/v1/regions/:id`

Exemple response:

```json
{
  "id": 4,
  "createdAt": "06:30:35 18-Mar-2022",
  "name": "Moldova",
  "localities": []
}
```

#### Query to add a region
`POST /api/v1/regions`

Exemple request body:
```json
{
  "name": "Dobrogea",
  "countryID" : 1
}
```

Exemple response:
```json
{
  "id": 6,
  "createdAt": "06:35:37 18-Mar-2022",
  "name": "Dobrogea",
  "localities": null
}
```

#### Query to update a region
`PUT /api/v1/regions/:id`

Exemple request body:

```json
{
  "name": "Muntenia",
  "countryID": 1
}
```
Exemple response:
```json
{
  "id": 4,
  "createdAt": "06:30:35 18-Mar-2022",
  "name": "Muntenia",
  "localities": [
    {
      "id": 7,
      "createdAt": "06:40:00 18-Mar-2022",
      "name": "Brasov",
      "sports": []
    }
  ]
}
```
#### Query to delete a region
`DELETE /api/v1/regions/:id`

#### Query for region with specific name
`GET /api/v1/regions/find?:name`

Exemple query:

`GET /api/v1/regions/find?name=Moldova`

Exemple response:

```json
{
  "id": 4,
  "createdAt": "06:30:35 18-Mar-2022",
  "name": "Moldova",
  "localities": [
    {
      "id": 7,
      "createdAt": "06:40:00 18-Mar-2022",
      "name": "Brasov",
      "sports": []
    }
  ]
}
```

#### Query for specific regions
`GET /api/v1/regions/find?:regions`

Exemple query:

`GET /api/v1/regions/find?regions=Moldova,Dobrogea`

Exemple response:

```json
[
  {
    "id": 4,
    "createdAt": "06:30:35 18-Mar-2022",
    "name": "Moldova",
    "localities": [
      {
        "id": 7,
        "createdAt": "06:40:00 18-Mar-2022",
        "name": "Brasov",
        "sports": []
      }
    ]
  },
  {
    "id": 6,
    "createdAt": "06:35:37 18-Mar-2022",
    "name": "Dobrogea",
    "localities": []
  }
]
```

##Localities
#### Query for all localities
`GET /api/v1/localities`

Example response:

```json
[
  {
    "id": 7,
    "createdAt": "06:40:00 18-Mar-2022",
    "name": "Brasov",
    "sports": []
  },
  {
    "id": 8,
    "createdAt": "07:20:39 18-Mar-2022",
    "name": "Poiana Brasov",
    "sports": []
  }
]
```

#### Query for a specific locality
`GET /api/v1/localities/:id`

Exemple response:

```json
{
  "id": 8,
  "createdAt": "07:20:39 18-Mar-2022",
  "name": "Poiana Brasov",
  "sports": []
}
```

#### Query to add a locality
`POST /api/v1/localities`

Exemple request body:
```json
{
  "name": "Poiana Brasov",
  "regionID" : 4
}
```

Exemple response:
```json
{
  "id": 8,
  "createdAt": "07:20:39 18-Mar-2022",
  "name": "Poiana Brasov",
  "sports": null
}
```

#### Query to update a locality
`PUT /api/v1/localities/:id`

Exemple request body:

```json
{
  "name": "Sinaia",
  "regionID": 4
}
```
Exemple response:
```json
{
  "id": 8,
  "createdAt": "07:20:39 18-Mar-2022",
  "name": "Sinaia",
  "sports": []
}
```
#### Query to delete a locality
`DELETE /api/v1/localities/:id`

#### Query for locality with specific name
`GET /api/v1/localities/find?:name`

Exemple query:

`GET /api/v1/localities/find?name=Brasov`

Exemple response:

```json
{
  "id": 7,
  "createdAt": "06:40:00 18-Mar-2022",
  "name": "Brasov",
  "sports": []
}
```

#### Query for specific localities
`GET /api/v1/localities/find?:localities`

Exemple query:

`GET /api/v1/localities/find?localities=Moldova,Dobrogea`

Exemple response:

```json
[
  {
    "id": 7,
    "createdAt": "06:40:00 18-Mar-2022",
    "name": "Brasov",
    "sports": []
  },
  {
    "id": 8,
    "createdAt": "07:20:39 18-Mar-2022",
    "name": "Sinaia",
    "sports": []
  }
]
```
##Sports
#### Query for all sports
`GET /api/v1/sports`

Example response:

```json
[
  {
    "id": 9,
    "createdAt": "07:37:29 18-Mar-2022",
    "name": "Ski",
    "dailyCost": 100,
    "startDate": "2021-11-30",
    "endDate": "2022-02-14"
  },
  {
    "id": 10,
    "createdAt": "07:37:58 18-Mar-2022",
    "name": "Snowboard",
    "dailyCost": 120,
    "startDate": "2021-11-30",
    "endDate": "2022-02-14"
  },
  {
    "id": 11,
    "createdAt": "07:38:07 18-Mar-2022",
    "name": "Motocross",
    "dailyCost": 60,
    "startDate": "2021-03-31",
    "endDate": "2022-07-24"
  },
  {
    "id": 12,
    "createdAt": "07:39:06 18-Mar-2022",
    "name": "Paragliding",
    "dailyCost": 300,
    "startDate": "2021-05-14",
    "endDate": "2022-09-14"
  }
]
```

#### Query for a specific sport
`GET /api/v1/sports/:id`

Exemple response:

```json
{
  "id": 12,
  "createdAt": "07:39:06 18-Mar-2022",
  "name": "Paragliding",
  "dailyCost": 300,
  "startDate": "2021-05-14",
  "endDate": "2022-09-14"
}
```

#### Query to add a sport
`POST /api/v1/sports`

Exemple request body:
```json
{
  "name": "Ski",
  "localityID" : 8,
  "dailyCost" : 100,
  "startDate" : "2021-12-01",
  "endDate": "2022-02-15"
}
```

Exemple response:
```json
{
  "id": 9,
  "createdAt": "07:37:29 18-Mar-2022",
  "name": "Ski",
  "dailyCost": 100,
  "startDate": "2021-12-01",
  "endDate": "2022-02-15"
}
```

#### Query to update a sport
`PUT /api/v1/sports/:id`

Exemple request body:

```json
{
  "name": "Skydiving",
  "localityID" : 7,
  "dailyCost" : 345,
  "startDate" : "2021-05-15",
  "endDate": "2022-09-15"
}
```
Exemple response:
```json
{
  "id": 12,
  "createdAt": "07:39:06 18-Mar-2022",
  "name": "Skydiving",
  "dailyCost": 300,
  "startDate": "2021-05-14",
  "endDate": "2022-09-14"
}
```

#### Query to delete a sport
`DELETE /api/v1/sports/:id`

#### Query for sport with specific name
`GET /api/v1/sports/find?:name`

Exemple query:

`GET /api/v1/sports/find?name=Ski`

Exemple response:

```json
{
  "id": 9,
  "createdAt": "07:37:29 18-Mar-2022",
  "name": "Ski",
  "dailyCost": 100,
  "startDate": "2021-11-30",
  "endDate": "2022-02-14"
}
```

#### Query for specific sports
`GET /api/v1/sports/find?:sports`

Exemple query:

`GET /api/v1/sports/find?sports=Ski,Skydiving`

Exemple response:

```json
[
  {
    "id": 9,
    "createdAt": "07:37:29 18-Mar-2022",
    "name": "Ski",
    "dailyCost": 100,
    "startDate": "2021-11-30",
    "endDate": "2022-02-14"
  },
  {
    "id": 12,
    "createdAt": "07:39:06 18-Mar-2022",
    "name": "Skydiving",
    "dailyCost": 300,
    "startDate": "2021-05-14",
    "endDate": "2022-09-14"
  }
]
```

#### Query for sport with specific cost
`GET /api/v1/sports/find?:cost`

Exemple query:

`GET /api/v1/sports/find?cost=100`

Exemple response:

```json
[
  {
    "id": 9,
    "createdAt": "07:37:29 18-Mar-2022",
    "name": "Ski",
    "dailyCost": 100,
    "startDate": "2021-11-30",
    "endDate": "2022-02-14"
  },
  {
    "id": 13,
    "createdAt": "07:55:26 18-Mar-2022",
    "name": "Snowboard",
    "dailyCost": 100,
    "startDate": "2021-11-30",
    "endDate": "2022-02-14"
  }
]
```

#### Query for sports with cost in range
`GET /api/v1/sports/find/cost/range:min,max`

Exemple query:

`GET /api/v1/sports/find/cost/range?min=100&max=320`

Exemple response:

```json
[
  {
    "id": 9,
    "createdAt": "07:37:29 18-Mar-2022",
    "name": "Ski",
    "dailyCost": 100,
    "startDate": "2021-11-30",
    "endDate": "2022-02-14"
  },
  {
    "id": 10,
    "createdAt": "07:37:58 18-Mar-2022",
    "name": "Snowboard",
    "dailyCost": 120,
    "startDate": "2021-11-30",
    "endDate": "2022-02-14"
  },
  {
    "id": 12,
    "createdAt": "07:39:06 18-Mar-2022",
    "name": "Skydiving",
    "dailyCost": 300,
    "startDate": "2021-05-14",
    "endDate": "2022-09-14"
  },
  {
    "id": 13,
    "createdAt": "07:55:26 18-Mar-2022",
    "name": "Snowboard",
    "dailyCost": 100,
    "startDate": "2021-11-30",
    "endDate": "2022-02-14"
  }
]
```

#### Query for sports between two dates
`GET /api/v1/sports/find:startDate,endDate`

Exemple query:

`GET /api/v1/sports/find?startDate=2022-05-01&endDate=2022-06-23`

Exemple response:

```json
[
  {
    "id": 11,
    "createdAt": "07:38:07 18-Mar-2022",
    "name": "Motocross",
    "dailyCost": 60,
    "startDate": "2021-03-31",
    "endDate": "2022-07-24"
  },
  {
    "id": 12,
    "createdAt": "07:39:06 18-Mar-2022",
    "name": "Skydiving",
    "dailyCost": 300,
    "startDate": "2021-05-14",
    "endDate": "2022-09-14"
  },
  {
    "id": 14,
    "createdAt": "08:05:33 18-Mar-2022",
    "name": "Mountain Climbing",
    "dailyCost": 145,
    "startDate": "2022-04-14",
    "endDate": "2022-09-14"
  }
]
```

#### Query for sport between two dates and specific name
`GET /api/v1/sports/find:name,startDate,endDate`

Exemple query:

`GET /api/v1/sports/find?name=Mountain Climbing&startDate=2022-05-01&endDate=2022-06-23`

Exemple response:

```json
{
  "id": 7,
  "createdAt": "08:14:42 18-Mar-2022",
  "name": "Mountain Climbing",
  "dailyCost": 145,
  "startDate": "2022-04-14",
  "endDate": "2022-09-14"
}
```