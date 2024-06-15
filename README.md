Please follow below steps to create request payload and I have given expected response body also.

-------------------------------------------------------------------------------------# Movie API Documentation---------------------------------------------------------------------------------------------------

1). ADD MOVIES

POST:  http://localhost:8080/api/movies

Request Payload: 
 {
        "title": "Movie 4",
        "genre": "Horror",
        "duration": 100,
        "language": "Spanish",
        "releaseDate": "2020-04-01"
}
Response:
{
    "id": 5,
    "title": "Movie 4",
    "genre": "Horror",
    "duration": 100,
    "language": "Spanish",
    "releaseDate": "2020-04-01T00:00:00.000+00:00"
}

2). GET ALL MOVIES
GET: http://localhost:8080/api/movies

Response:


[
    {
        "id": 1,
        "title": "Movie 1",
        "genre": "Action",
        "duration": 120,
        "language": "English",
        "releaseDate": "2020-01-01T00:00:00.000+00:00"
    },
    {
        "id": 2,
        "title": "Movie 2",
        "genre": "Comedy",
        "duration": 90,
        "language": "English",
        "releaseDate": "2020-02-01T00:00:00.000+00:00"
    },
    {
        "id": 3,
        "title": "Movie 5",
        "genre": "Romance",
        "duration": 110,
        "language": "English",
        "releaseDate": "2020-05-01T00:00:00.000+00:00"
    },
    {
        "id": 4,
        "title": "Movie 3",
        "genre": "Drama",
        "duration": 150,
        "language": "French",
        "releaseDate": "2020-03-01T00:00:00.000+00:00"
    },
    {
        "id": 5,
        "title": "Movie 4",
        "genre": "Horror",
        "duration": 100,
        "language": "Spanish",
        "releaseDate": "2020-04-01T00:00:00.000+00:00"
    }
]

3). UPDATE MOVIE

PUT: http://localhost:8080/api/movies/2

REQUEST
{
        "id": 2,
        "title": "Inception",
        "genre": "Action, Sci-Fi",
        "duration": 148,
        "language": "English",
        "releaseDate": "2010-07-16"
}

RESPONSE
{
    "id": 2,
    "title": "Inception",
    "genre": "Action, Sci-Fi",
    "duration": 148,
    "language": "English",
    "releaseDate": "2010-07-16T00:00:00.000+00:00"
}
--------------------------------------------------------------------------------------# User API Documentation---------------------------------------------------------------------------------------------------

1). add user

POST: http://localhost:8080/api/users

REQUEST
{
        "username": "user5",
        "password": "password123",
        "email": "user5@example.com",
        "role": "admin"
}
RESPONSE
{
    "id": 5,
    "username": "user5",
    "password": "password123",
    "email": "user5@example.com",
    "role": "admin",
    "createdAt": "2024-06-15T04:25:29.388+00:00",
    "updatedAt": "2024-06-15T04:25:29.388+00:00"
}

2). GET USERS

GET: http://localhost:8080/api/users

RESPONSE
[
    {
        "id": 1,
        "username": "user1",
        "password": "password123",
        "email": "user1@example.com",
        "role": "admin",
        "createdAt": "2024-06-15T04:24:43.644+00:00",
        "updatedAt": "2024-06-15T04:24:43.644+00:00"
    },
    {
        "id": 2,
        "username": "user2",
        "password": "password123",
        "email": "user2@example.com",
        "role": "user",
        "createdAt": "2024-06-15T04:25:00.500+00:00",
        "updatedAt": "2024-06-15T04:25:00.500+00:00"
    },
    {
        "id": 3,
        "username": "user3",
        "password": "password123",
        "email": "user3@example.com",
        "role": "user",
        "createdAt": "2024-06-15T04:25:10.799+00:00",
        "updatedAt": "2024-06-15T04:25:10.799+00:00"
    },
    {
        "id": 4,
        "username": "user4",
        "password": "password123",
        "email": "user4@example.com",
        "role": "moderator",
        "createdAt": "2024-06-15T04:25:20.506+00:00",
        "updatedAt": "2024-06-15T04:25:20.506+00:00"
    },
    {
        "id": 5,
        "username": "user5",
        "password": "password123",
        "email": "user5@example.com",
        "role": "admin",
        "createdAt": "2024-06-15T04:25:29.388+00:00",
        "updatedAt": "2024-06-15T04:25:29.388+00:00"
    }
]

--------------------------------------------------------------------------------------# SHOW API Documentation---------------------------------------------------------------------------------------------------

1). ADD SHOW

POST: http://localhost:8080/api/shows

REQUEST
{
        "movieTitle": "Movie E",
        "showTime": "2024-07-03T17:30:00",
        "theaterName": "Theater 5",
        "movieId": 5,
        "availableSeats": 100
}
RESPONSE
{
    "id": 5,
    "movieTitle": "Movie E",
    "theaterName": "Theater 5",
    "showTime": "2024-06-15T04:22:56.295+00:00",
    "movie": {
        "id": 5,
        "title": "Movie 4",
        "genre": "Horror",
        "duration": 100,
        "language": "Spanish",
        "releaseDate": "2020-04-01T00:00:00.000+00:00"
    },
    "availableSeats": 100
}

2). GET ALL SHOWS

GET: http://localhost:8080/api/shows

RESPONSE:

[
    {
        "id": 1,
        "movieTitle": "Movie A",
        "theaterName": "Theater 1",
        "showTime": "2024-06-15T04:22:11.459+00:00",
        "movie": {
            "id": 1,
            "title": "Movie 1",
            "genre": "Action",
            "duration": 120,
            "language": "English",
            "releaseDate": "2020-01-01T00:00:00.000+00:00"
        },
        "availableSeats": 93
    },
    {
        "id": 2,
        "movieTitle": "Movie B",
        "theaterName": "Theater 2",
        "showTime": "2024-06-15T04:22:21.744+00:00",
        "movie": {
            "id": 2,
            "title": "Movie 2",
            "genre": "Comedy",
            "duration": 90,
            "language": "English",
            "releaseDate": "2020-02-01T00:00:00.000+00:00"
        },
        "availableSeats": 94
    },
    {
        "id": 3,
        "movieTitle": "Movie C",
        "theaterName": "Theater 3",
        "showTime": "2024-06-15T04:22:33.702+00:00",
        "movie": {
            "id": 3,
            "title": "Movie 5",
            "genre": "Romance",
            "duration": 110,
            "language": "English",
            "releaseDate": "2020-05-01T00:00:00.000+00:00"
        },
        "availableSeats": 98
    },
    {
        "id": 4,
        "movieTitle": "Movie D",
        "theaterName": "Theater 4",
        "showTime": "2024-06-15T04:22:44.866+00:00",
        "movie": {
            "id": 4,
            "title": "Movie 3",
            "genre": "Drama",
            "duration": 150,
            "language": "French",
            "releaseDate": "2020-03-01T00:00:00.000+00:00"
        },
        "availableSeats": 94
    },
    {
        "id": 5,
        "movieTitle": "Movie E",
        "theaterName": "Theater 5",
        "showTime": "2024-06-15T04:22:56.295+00:00",
        "movie": {
            "id": 5,
            "title": "Movie 4",
            "genre": "Horror",
            "duration": 100,
            "language": "Spanish",
            "releaseDate": "2020-04-01T00:00:00.000+00:00"
        },
        "availableSeats": 95
    }
]
--------------------------------------------------------------------------------------# BOOKING API Documentation---------------------------------------------------------------------------------------------------

1). CREATE BOOKING

POST: http://localhost:8080/api/bookings/create

REQUEST:
{
        "userId": 5,
        "showId": 1,
        "numberOfSeats": 4
}
RESPONSE
{
    "id": 11,
    "userId": 5,
    "show": {
        "id": 1,
        "movieTitle": "Movie A",
        "theaterName": "Theater 1",
        "showTime": "2024-06-15T04:22:11.459+00:00",
        "movie": {
            "id": 1,
            "title": "Movie 1",
            "genre": "Action",
            "duration": 120,
            "language": "English",
            "releaseDate": "2020-01-01T00:00:00.000+00:00"
        },
        "availableSeats": 91
    }
}

2). GET ALL BOOKINGS

GET: http://localhost:8080/api/bookings/all

RESPONSE:
[
    {
        "id": 1,
        "userId": 1,
        "show": {
            "id": 1,
            "movieTitle": "Movie A",
            "theaterName": "Theater 1",
            "showTime": "2024-06-15T04:22:11.459+00:00",
            "movie": {
                "id": 1,
                "title": "Movie 1",
                "genre": "Action",
                "duration": 120,
                "language": "English",
                "releaseDate": "2020-01-01T00:00:00.000+00:00"
            },
            "availableSeats": 91
        }
    },
    {
        "id": 2,
        "userId": 1,
        "show": {
            "id": 1,
            "movieTitle": "Movie A",
            "theaterName": "Theater 1",
            "showTime": "2024-06-15T04:22:11.459+00:00",
            "movie": {
                "id": 1,
                "title": "Movie 1",
                "genre": "Action",
                "duration": 120,
                "language": "English",
                "releaseDate": "2020-01-01T00:00:00.000+00:00"
            },
            "availableSeats": 91
        }
    },
    {
        "id": 3,
        "userId": 2,
        "show": {
            "id": 2,
            "movieTitle": "Movie B",
            "theaterName": "Theater 2",
            "showTime": "2024-06-15T04:22:21.744+00:00",
            "movie": {
                "id": 2,
                "title": "Movie 2",
                "genre": "Comedy",
                "duration": 90,
                "language": "English",
                "releaseDate": "2020-02-01T00:00:00.000+00:00"
            },
            "availableSeats": 94
        }
    },
    {
        "id": 4,
        "userId": 3,
        "show": {
            "id": 3,
            "movieTitle": "Movie C",
            "theaterName": "Theater 3",
            "showTime": "2024-06-15T04:22:33.702+00:00",
            "movie": {
                "id": 3,
                "title": "Movie 5",
                "genre": "Romance",
                "duration": 110,
                "language": "English",
                "releaseDate": "2020-05-01T00:00:00.000+00:00"
            },
            "availableSeats": 98
        }
    },
    {
        "id": 5,
        "userId": 4,
        "show": {
            "id": 4,
            "movieTitle": "Movie D",
            "theaterName": "Theater 4",
            "showTime": "2024-06-15T04:22:44.866+00:00",
            "movie": {
                "id": 4,
                "title": "Movie 3",
                "genre": "Drama",
                "duration": 150,
                "language": "French",
                "releaseDate": "2020-03-01T00:00:00.000+00:00"
            },
            "availableSeats": 94
        }
    },
    {
        "id": 6,
        "userId": 5,
        "show": {
            "id": 5,
            "movieTitle": "Movie E",
            "theaterName": "Theater 5",
            "showTime": "2024-06-15T04:22:56.295+00:00",
            "movie": {
                "id": 5,
                "title": "Movie 4",
                "genre": "Horror",
                "duration": 100,
                "language": "Spanish",
                "releaseDate": "2020-04-01T00:00:00.000+00:00"
            },
            "availableSeats": 95
        }
    },
    {
        "id": 7,
        "userId": 1,
        "show": {
            "id": 2,
            "movieTitle": "Movie B",
            "theaterName": "Theater 2",
            "showTime": "2024-06-15T04:22:21.744+00:00",
            "movie": {
                "id": 2,
                "title": "Movie 2",
                "genre": "Comedy",
                "duration": 90,
                "language": "English",
                "releaseDate": "2020-02-01T00:00:00.000+00:00"
            },
            "availableSeats": 94
        }
    },
    {
        "id": 8,
        "userId": 2,
        "show": {
            "id": 3,
            "movieTitle": "Movie C",
            "theaterName": "Theater 3",
            "showTime": "2024-06-15T04:22:33.702+00:00",
            "movie": {
                "id": 3,
                "title": "Movie 5",
                "genre": "Romance",
                "duration": 110,
                "language": "English",
                "releaseDate": "2020-05-01T00:00:00.000+00:00"
            },
            "availableSeats": 98
        }
    },
    {
        "id": 9,
        "userId": 3,
        "show": {
            "id": 4,
            "movieTitle": "Movie D",
            "theaterName": "Theater 4",
            "showTime": "2024-06-15T04:22:44.866+00:00",
            "movie": {
                "id": 4,
                "title": "Movie 3",
                "genre": "Drama",
                "duration": 150,
                "language": "French",
                "releaseDate": "2020-03-01T00:00:00.000+00:00"
            },
            "availableSeats": 94
        }
    },
    {
        "id": 10,
        "userId": 4,
        "show": {
            "id": 5,
            "movieTitle": "Movie E",
            "theaterName": "Theater 5",
            "showTime": "2024-06-15T04:22:56.295+00:00",
            "movie": {
                "id": 5,
                "title": "Movie 4",
                "genre": "Horror",
                "duration": 100,
                "language": "Spanish",
                "releaseDate": "2020-04-01T00:00:00.000+00:00"
            },
            "availableSeats": 95
        }
    },
    {
        "id": 11,
        "userId": 5,
        "show": {
            "id": 1,
            "movieTitle": "Movie A",
            "theaterName": "Theater 1",
            "showTime": "2024-06-15T04:22:11.459+00:00",
            "movie": {
                "id": 1,
                "title": "Movie 1",
                "genre": "Action",
                "duration": 120,
                "language": "English",
                "releaseDate": "2020-01-01T00:00:00.000+00:00"
            },
            "availableSeats": 91
        }
    }
]

3). CANCEL BOOKING

DELETE: http://localhost:8080/api/bookings/delete/1

RESPONSE:
{
    "id": 1,
    "userId": 1,
    "show": {
        "id": 1,
        "movieTitle": "Movie A",
        "theaterName": "Theater 1",
        "showTime": "2024-06-15T04:22:11.459+00:00",
        "movie": {
            "id": 1,
            "title": "Movie 1",
            "genre": "Action",
            "duration": 120,
            "language": "English",
            "releaseDate": "2020-01-01T00:00:00.000+00:00"
        },
        "availableSeats": 93
    }
}
