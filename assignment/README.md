# Assignement Centric

## Technologies
+ Java 1.8
+ Spring 5.2
+ Spring Reactor
+ Netty Server
+ H2 Database

## Endpoint - POST

Insert a product with specific attributes

**URL** : `/v1/products`

**Method** : `POST`

**JSON Example**

{
	"name": "Blue Shirt",
	"description": "Red hugo boss shirt",
	"brand": "Hugo Boss",
	"tags": [
					"red", 
					"shirt",
					"slim fit"
			],
	"category": "apparel"
	
}

## Endpoint - GET

Get all paged products by category and the newest

**URL** : `http://localhost:8080/v1/products?category=apparel&page=0&limit=10`

**Method** : `GET`

