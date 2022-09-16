# SummonSimulatorAPI

## Introduction
This is a REST API that simulates the gacha mechanic in Genshin Impact. Using Postman is recommended to interact with the API through HTTP requests. Please copy and paste the URI after the base URI and enter the described request parameters to make a request.

## Terminology
### Rarity
The items are characters and weapons, with rarity ratings of 3 star, 4 star or 5 star. Higher stars represent smaller probability to receive the item.

### Pity counters
Within every 10 summons, there is a guaranteed drop of a 4 star item. The internal pity counter will increment from 0 up to 10, if the player receives a 4 star item, the counter will reset to 0. Otherwise, the 10th summmon is guaranteed to be a 4 star item. 

Within every 90 summons, there is a guaranteed drop of a 5 star item. This pity counter is separate from the 4 star counter. When the player receives a 5 star item, the counter will reset to 0. Otherwise, the 90th summon is guaranteed to be a 5 star item.

There is a soft-pity mechanic from the 75th summon up to the 90th summon. The probability of a 5 star item dropping will progressively increase from the base rate up to a 25% chance. 

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

Summons 10 times on the permanent banner. The backend service handles changes to the pity count and will modify drop rates for 4 or 5 star items according to the above rules.

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

Request Parameter:

| Key | Value | Description |
| --- | --- | --- |
| name | string | the name of the item to delete |

<br/>

**GET** api/permBanner/allItems

Returns all of the items in the pool.

<br/>

**GET** api/permBanner/getByName

Get an item by its name. Returns nothing if there is no matching item.

Request Parameter:

| Key | Value | Description |
| --- | --- | --- |
| name | string | the name of the item to delete |

<br/>

**GET** api/permBanner/getByRarity

Get a list of all items with the provided rarity. Returns an empty list if there are no matching items.

Request Parameter:

| Key | Value | Description |
| --- | --- | --- |
| rarity | integer | rarity between 3 to 5 inclusive |

<br/>

**GET** api/permBanner/getByType

Get a list of all items with the given type. Returns an empty list if there are no matching items.

Request Parameter:

| Key | Value | Description |
| --- | --- | --- |
| type | string | type is either character or weapon |

<br/>

**GET** api/permBanner/getByRarityAndType

Get a list of all items with the given type and rarity. Returns an empty list if there are no matching items.

Request Parameters:

| Key | Value | Description |
| --- | --- | --- |
| rarity | integer | rarity between 3 to 5 inclusive |
| type | string | type is either character or weapon |



























