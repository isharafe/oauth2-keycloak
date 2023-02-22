# Description

Here demonstrates the "OAuth2 PKCE flow"

* With the Authorization code flow, we need to send client-id + client-secret to the authorization server
* For this, our app (client) need to store these data (id + secret) somewhere
* This is not an issue when we use a spring (java) back-end application, as the secret is not visible to public
* But when our app (client) is a public one, (ex: we don't have a back-end application, we only have a front-end application) we shouldn't store client-secret in the application. As this secret will be visible to the public.
* This is when the PKCE flow is useful


![pkce_code_flow](https://user-images.githubusercontent.com/13161714/220785077-119d5d6c-66e9-4a33-8f74-a871947c925c.png)

## Key-cloak configuration

* Create a new realm (or use an existing realm)
* Create a client
   * give a client id
   * give a redirect url, ex: http://localhost:4200 - home page of the front-end application
   * Client Authentication = OFF ==> this is a public client
   * Authentication flow = Standard flow
* Create a User and create a password for this user (or you may use existing users of this realm)
* set "Web Origin Url" to "*" - in a production environment, set the host url of the front-end server
* set "Proof Key for Code Exchange Code Challenge Method" to "S256"


## Usage

 * run the spring application
 * go to "http://localhost:8080/home"
 * you will be redirect to a login page
 * enter user and password details which you created in keycloak
 * after successful login, you will be redirected to the home page
