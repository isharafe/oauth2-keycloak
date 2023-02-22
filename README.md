# Description

Here demonstrates the "OAuth2 Client credentials flow"

![client_credentials_flow](https://user-images.githubusercontent.com/13161714/220785387-4691004c-504e-4c49-a4c9-7d27fb35d26b.png)

## Key-cloak configuration

* Create a new realm (or use an existing realm)
* Create a client
   * give a client id
   * Client Authentication = ON ==> this is a confidential client, not a public client
   * Authentication flow = Service accounts roles (client credentials flow)
* Create a User and create a password for this user (or you may use existing users of this realm)

## Use postman for testing

* Go to "Authorization" tab in postman
* Select Type = OAuth2
* Token Type = Access Token
* Header Prefix = Bearer
* Configuration
    * Token Name = [any name for this token]
    * Grant Type = Client Credentials
    * Access Token URL = [get url from : Key Cloak -> Realm settings -> token_endpoint]
    * Client ID = [use client's id, created in keycloak]
    * Client credentials = [use client's secret, created in keycloak]
    * Client Authentication = Send as Basic Auth header

* Click "Get New Access Token"
    * A new token will generate by accessing given url, using given client credentials. this token will be send in the header as the bearer token.
* send the request to server
  * request type = GET
  * url = localhost:8083/microservice1/home
  * use url = localhost:8083/microservice1/home/web-client , to use the web-client to complete the request

### use postman for testing - get an access-token and a refresh-token
 * TODO
 * use scope=offline_access to get a non-expiring refresh token

## use postman to get an access-token
`this process is similar to what postman does when we do the Oauth2 authorization configuration`
 * go to keycloak realm settings
 * click on "Openid Configuration"
 * get the "token_endpoint" url
 * open postman
   * request type = POST
   * url = above copied "token_endpoint"
   * BODY
     * x-www-form-urlencoded
	 * fields:
	   * grant_type=client_credentials
	   * client_id={client_id_from_keycloak}
	   * client_secret={client_secret_from_keycloak}

## use postman to get an access-token using refresh token

 * go to keycloak realm settings
 * click on "Openid Configuration"
 * get the "token_endpoint" url
 * open postman
   * request type = POST
   * url = above copied "token_endpoint"
   * BODY
     * x-www-form-urlencoded
	 * fields:
	   * grant_type=refresh_token
	   * client_id={client_id_from_keycloak}
	   * client_secret={client_secret_from_keycloak}
	   * refresh_token={refresh_token}
