
# SLAM STATS API

This is my first API created with Spring Boot that will be implemented in my 
android app, wich you can check out in my repositories. Currently, I'm learning new functionalities of Spring as well as software architectures and how to use lambda functions. I'm trying to implement these in my API.

You can check out the following documentation to try the API by yourself.


## API Reference

### Players

#### GET all the players

```http
  GET https://test-production-6b7f.up.railway.app/slamstats/players/all?page=0
```

| Parameter | Required     | Description                |
| :-------- | :------- | :------------------------- |
| `page` | `false` | Pagination of the result(25 players per page)|

##### The Json will look like that:

```
    [
        {
            "id": 1,
            "nombreCompleto": "Michael Jordan",
            "nacionalidad": "Estadounidense",
            "altura": "1.98",
            "peso": "98.00",
            "posicion": "Escolta",
            "dorsal": "23",
            "fotoCabeza": "https://cdn.nba.com/headshots/nba/latest/1040x760/893.png",
            "fotoCompleta": "https://media.vogue.es/photos/5ea1dfcae7a75f000938445e/2:3/w_2560%2Cc_limit/GettyImages-52298709.jpg",
            "fnacimiento": "1963-02-16T23:00:00.000+00:00"
        },
        {
            "id": 2,
            "nombreCompleto": "Kobe Bryant",
            "nacionalidad": "Estados Unidos",
            "altura": "1.98",
            "peso": "96.00",
            "posicion": "Escolta",
            "dorsal": "24",
            "fotoCabeza": "https://cdn.nba.com/headshots/nba/latest/1040x760/977.png",
            "fotoCompleta": "https://w0.peakpx.com/wallpaper/267/464/HD-wallpaper-kobe-bryant-dunk-basketball.jpg",
            "fnacimiento": "1978-08-22T22:00:00.000+00:00"
        },
    ...
    ]

```

#### GET Player by ID

```http
  GET https://test-production-6b7f.up.railway.app/slamstats/players/{id}
```

| Parameter | Required     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `true` | ID of the player to fetch |

##### The Json will look like that:

```
    {
        "id": 1,
        "nombreCompleto": "Michael Jordan",
        "nacionalidad": "Estadounidense",
        "altura": "1.98",
        "peso": "98.00",
        "posicion": "Escolta",
        "dorsal": "23",
        "fotoCabeza": "https://cdn.nba.com/headshots/nba/latest/1040x760/893.png",
        "fotoCompleta": "https://media.vogue.es/photos/5ea1dfcae7a75f000938445e/2:3/w_2560%2Cc_limit/GettyImages-52298709.jpg",
        "fnacimiento": "1963-02-16T23:00:00.000+00:00"
    }

```

#### GET Player Teams By Player ID

```http
  GET https://test-production-6b7f.up.railway.app/slamstats/players/{id}/teams
```

| Parameter | Required     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `true` | ID of the player to fetch the teams|

##### The Json will look like that:

```
[
    {
        "id": 1,
        "nombreEquipo": "Chicago Bulls",
        "abreviatura": "CHI"
    },
    {
        "id": 2,
        "nombreEquipo": "Washington Wizards",
        "abreviatura": "WAS"
    }
]
```

#### GET Player Players by name

```http
  GET https://test-production-6b7f.up.railway.app/slamstats/players?nombre=Kawhi&page=0
```

| Parameter | Required     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `nombre`      | `true` | Name of the player to fetch|
| `page`      | `false` | Pagination of the result(25 players per page)|

##### The Json will look like that:
```
[
    {
        "id": 13,
        "nombreCompleto": "Kawhi Leonard",
        "nacionalidad": "Estadounidense",
        "altura": "2.01",
        "peso": "230.00",
        "posicion": "Alero",
        "dorsal": "2",
        "fotoCabeza": "https://cdn.nba.com/headshots/nba/latest/1040x760/202695.png",
        "fotoCompleta": "https://i.pinimg.com/474x/1a/08/55/1a085508d7a44299675b071c96e3117c.jpg",
        "fnacimiento": "1991-06-28T22:00:00.000+00:00"
    }
]
```


### Teams

#### GET all the teams

```http
  GET https://test-production-6b7f.up.railway.app/slamstats/teams
```
##### It will return the 30 teams of the NBA:
```
[
    {
        "id": 1,
        "nombreEquipo": "Chicago Bulls",
        "abreviatura": "CHI",
        "descripcion": "Los Chicago Bulls, establecidos en 1966, son una franquicia icónica de la NBA con sede en Chicago, Illinois. Celebrados por su dinastía en la década de 1990 liderada por Michael Jordan, Scottie Pippen y el entrenador Phil Jackson, los Bulls han ganado múltiples campeonatos. Su legado está marcado por la grandeza competitiva y un estatus legendario en la historia del baloncesto profesional. Con los característicos colores rojo, negro y blanco, los Chicago Bulls continúan siendo un símbolo.",
        "fechaFundacion": "1966-01-15T23:00:00.000+00:00",
        "titulos": 6,
        "numeroRetirados": [
            {
                "id": 45,
                "numero": "4#",
                "jugador": "Jerry Sloan"
            },
            {
                "id": 46,
                "numero": "10#",
                "jugador": "Bob Love"
            },
            {
                "id": 47,
                "numero": "23#",
                "jugador": "Michael Jordan"
            },
            {
                "id": 48,
                "numero": "33#",
                "jugador": "Scottie Pippen"
            },
            {
                "id": 49,
                "numero": "54#",
                "jugador": "Horace Grant"
            }
        ]
    },
    ...
]
```

#### GET Team By ID

```http
  GET https://test-production-6b7f.up.railway.app/slamstats/team/{id}
``` 

| Parameter | Required     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `true` | ID of the team|


##### The Json will look like that

```
{
    "id": 1,
    "nombreEquipo": "Chicago Bulls",
    "abreviatura": "CHI",
    "descripcion": "Los Chicago Bulls, establecidos en 1966, son una franquicia icónica de la NBA con sede en Chicago, Illinois. Celebrados por su dinastía en la década de 1990 liderada por Michael Jordan, Scottie Pippen y el entrenador Phil Jackson, los Bulls han ganado múltiples campeonatos. Su legado está marcado por la grandeza competitiva y un estatus legendario en la historia del baloncesto profesional. Con los característicos colores rojo, negro y blanco, los Chicago Bulls continúan siendo un símbolo.",
    "fechaFundacion": "1966-01-15T23:00:00.000+00:00",
    "titulos": 6,
    "numeroRetirados": [
        {
            "id": 45,
            "numero": "4#",
            "jugador": "Jerry Sloan"
        },
        {
            "id": 46,
            "numero": "10#",
            "jugador": "Bob Love"
        },
        {
            "id": 47,
            "numero": "23#",
            "jugador": "Michael Jordan"
        },
        {
            "id": 48,
            "numero": "33#",
            "jugador": "Scottie Pippen"
        },
        {
            "id": 49,
            "numero": "54#",
            "jugador": "Horace Grant"
        }
    ]
}
```

#### GET Teams By Name

```http
  GET https://test-production-6b7f.up.railway.app/slamstats/team?nombre=San Antonio
``` 

| Parameter | Required     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `nombre`      | `true` | Name of the team|

##### The Json will look like that

```
[
    {
        "id": 10,
        "nombreEquipo": "San Antonio Spurs",
        "abreviatura": "SAS",
        "descripcion": "Equipo de San Antonio, Texas, conocido por su éxito en la NBA.",
        "fechaFundacion": "1967-04-30T23:00:00.000+00:00",
        "titulos": 5,
        "numeroRetirados": [
            {
                "id": 180,
                "numero": "00#",
                "jugador": "Johnny Moore"
            },
            {
                "id": 181,
                "numero": "6#",
                "jugador": "Avery Johnson"
            },
            {
                "id": 182,
                "numero": "9#",
                "jugador": "Tony Parker"
            },
            {
                "id": 183,
                "numero": "12#",
                "jugador": "Bruce Bowen"
            },
            {
                "id": 184,
                "numero": "13#",
                "jugador": "James Silas"
            },
            {
                "id": 185,
                "numero": "20#",
                "jugador": "Manu Ginóbili"
            },
            {
                "id": 186,
                "numero": "21#",
                "jugador": "Tim Duncan"
            },
            {
                "id": 187,
                "numero": "32#",
                "jugador": "Sean Elliott"
            },
            {
                "id": 188,
                "numero": "44#",
                "jugador": "George Gervin"
            },
            {
                "id": 189,
                "numero": "50#",
                "jugador": "David Robinson"
            }
        ]
    }
]
```

#### GET Teams Retired Jerseys

```http
  GET https://test-production-6b7f.up.railway.app/slamstats/team/{id}/retiredNumbers
``` 

| Parameter | Required     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `true` | ID of the team that you want to get the retired jerseys|

```
[
    {
        "id": 45,
        "numero": "4#",
        "jugador": "Jerry Sloan"
    },
    {
        "id": 46,
        "numero": "10#",
        "jugador": "Bob Love"
    },
    {
        "id": 47,
        "numero": "23#",
        "jugador": "Michael Jordan"
    },
    {
        "id": 48,
        "numero": "33#",
        "jugador": "Scottie Pippen"
    },
    {
        "id": 49,
        "numero": "54#",
        "jugador": "Horace Grant"
    }
]
```

### Trophies

#### GET all the trophies

```http
  GET https://test-production-6b7f.up.railway.app/slamstats/trophies
  ``` 
##### The Json will look like that:
  ```
  [
    {
        "id": 1,
        "anillos": 6,
        "fmvp": 6,
        "mvp": 5,
        "allstar": 14,
        "dpoy": 1,
        "roy": 1
    },

    ...
  ]
  ```
  
  #### GET trophies by ID

```http
  GET https://test-production-6b7f.up.railway.app/slamstats/trophies/{id}
  ``` 
  | Parameter | Required     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `true` | ID of throphies that you want|

##### The Json will look like that:

```
{
    "id": 1,
    "anillos": 6,
    "fmvp": 6,
    "mvp": 5,
    "allstar": 14,
    "dpoy": 1,
    "roy": 1
}
  ```

#### GET trophies by Player ID

```http
  GET https://test-production-6b7f.up.railway.app/slamstats/trophies/players/{id}
  ``` 
  | Parameter | Required     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `true` | ID of the player whose trophies you want to fetch.|

##### The Json will look like that:

```
{
    "id": 1,
    "anillos": 6,
    "fmvp": 6,
    "mvp": 5,
    "allstar": 14,
    "dpoy": 1,
    "roy": 1
}
  ```

### Stats

#### GET all the stats (Pending modification)

```http
  GET https://test-production-6b7f.up.railway.app/slamstats/stats
  ``` 

##### The Json will look like that:

```
[
    {
        "id": 1,
        "season": "1984-1985",
        "pj": 82,
        "ppp": 9.9,
        "tc": "51",
        "tl": "85",
        "rpp": 6.5,
        "app": 5.9,
        "stl": 2.4,
        "blk": 0.8,
        "pm3": 0.1,
        "perc3": "18"
    },

    ...
]
  ```

#### GET stats by ID

```http
  GET https://test-production-6b7f.up.railway.app/slamstats/stats/{id}
  ``` 

##### The Json will look like that:

```
{
    "id": 1,
    "season": "1984-1985",
    "pj": 82,
    "ppp": 9.9,
    "tc": "51",
    "tl": "85",
    "rpp": 6.5,
    "app": 5.9,
    "stl": 2.4,
    "blk": 0.8,
    "pm3": 0.1,
    "perc3": "18"
}
  ```

#### GET stats by Player ID

```http
  GET https://test-production-6b7f.up.railway.app/slamstats/stats/player/{id}
  ``` 

| Parameter | Required     | Description                   |
| :-------- | :------- | :-------------------------------- |
| `id`      | `true` | ID of the player whose stats you want to fetch.|

##### The Json will look like that, an array of al the stats per season:

```
[   
    {
        "id": 1,
        "season": "1984-1985",
        "pj": 82,
        "ppp": 9.9,
        "tc": "51",
        "tl": "85",
        "rpp": 6.5,
        "app": 5.9,
        "stl": 2.4,
        "blk": 0.8,
        "pm3": 0.1,
        "perc3": "18"
    },

    ...
]
  ```

### User

#### POST new user

```http
  POST https://test-production-6b7f.up.railway.app/slamstats/user/register
  ``` 

##### Request Body:
```
{
    "nombreUsuario": "1",
    "correo": "example@example.com",
    "passwd": "1"
} 
```

#### DELETE new favorite player

```http
  DELETE https://test-production-6b7f.up.railway.app/slamstats/user/addFavorite?idPlayer=2&idUser=1
  ``` 
| Parameter | Required     | Description                   |
| :-------- | :------- | :-------------------------------- |
| `idPlayer`      | `true` | ID of the player who will be added to favorites.|
| `idUser`      | `true` | ID of the user.|

#### GET All the favorite players of the user

```http
  GET https://test-production-6b7f.up.railway.app/slamstats/user/{id}/favoritePlayers
  ``` 
| Parameter | Required     | Description                   |
| :-------- | :------- | :-------------------------------- |
| `id`      | `true` | ID of the user who wants to retrieve the favorite players.|

##### The Json will look like that 
```
[
    {
        "id": 1,
        "nombreCompleto": "Michael Jordan",
        "nacionalidad": "Estadounidense",
        "altura": "1.98",
        "peso": "98.00",
        "posicion": "Escolta",
        "dorsal": "23",
        "fotoCabeza": "https://cdn.nba.com/headshots/nba/latest/1040x760/893.png",
        "fotoCompleta": "https://media.vogue.es/photos/5ea1dfcae7a75f000938445e/2:3/w_2560%2Cc_limit/GettyImages-52298709.jpg",
        "fnacimiento": "1963-02-16T23:00:00.000+00:00"
    },
    {
        "id": 2,
        "nombreCompleto": "Kobe Bryant",
        "nacionalidad": "Estados Unidos",
        "altura": "1.98",
        "peso": "96.00",
        "posicion": "Escolta",
        "dorsal": "24",
        "fotoCabeza": "https://cdn.nba.com/headshots/nba/latest/1040x760/977.png",
        "fotoCompleta": "https://w0.peakpx.com/wallpaper/267/464/HD-wallpaper-kobe-bryant-dunk-basketball.jpg",
        "fnacimiento": "1978-08-22T22:00:00.000+00:00"
    }
]
```

#### GET Login 

```http
  GET https://test-production-6b7f.up.railway.app/slamstats/useruser/login?userName=1&passwd=1
  ``` 
| Parameter | Required     | Description                   |
| :-------- | :------- | :-------------------------------- |
| `userName`      | `true` | Username of the user who wants to log in|
| `passwd`      | `true` | password of the user|

##### The Json will look like that:
```
{
    "id": 4,
    "nombreUsuario": "1",
    "correo": "example@example.com"
}
``` 

#### GET If a player is favorite 

```http
  GET https://test-production-6b7f.up.railway.app/slamstats/user/{idUser}/favoritePlayers/{idPlayer}
  ``` 
| Parameter | Required     | Description                   |
| :-------- | :------- | :-------------------------------- |
| `idUser`      | `true` | User ID from which favorites will be retrieved. |
| `idPlayer`      | `true` | Player ID to check if he is in favorite.|

## Authors

- [@Mariskii](https://www.github.com/Mariskii)
