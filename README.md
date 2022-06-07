# SummonSimulatorAPI

## Introduction
This is a REST API that allows clients to simulate the gacha mechanic in the video game Genshin Impact. 

## API Endpoints
Base URI: https://summon-simulator-api.herokuapp.com

<br/>

**GET** /api/permBanner/summon

Summons once on the permanent banner.

Request Parameters:

| Key | Value | Description |
| --- | --- | --- |
| pity | integer >= 0 | pity count for 5 star drop |
| fs | integer >= 0 and <= 10 | pity count for 4 star drop |
  
<br/>
  
**GET** api/permBanner/multi

Summons 10 times on the permanent banner. The backend service handles changes to the pity count and will modify drop rates for 4 or 5 star items accordingly.

Request Paramters:

| Key | Value | Description |
| --- | --- | --- |
| pity | integer >= 0 | pity count for 5 star drop |
| fs | integer >= 0 and <= 10 | pity count for 4 star drop |

<br/>

**POST** api/permBanner/addToPool

Adds an item into the summoning pool. A JSON request body is required. The rarity is an integer between 3 to 5 inclusive, 
the name is a string and the type is either "character" or "weapon". 

Example of Request Body Formatting:
```json
{
    "rarity": 5,
    "name": "Kokomi",
    "type": "character"
}
```

<br/>

**DELETE** api/permBanner/deleteFromPool

Deletes a specified item from the summoning pool by name lookup.

| Key | Value | Description |
| --- | --- | --- |
| name | string | the name of the item to delete |

<br/>

**GET** api/permBanner/allItems

Returns all of the items in the pool.

<br/>

