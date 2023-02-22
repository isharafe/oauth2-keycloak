import { AuthConfig } from "angular-oauth2-oidc";

export const authConfig : AuthConfig = {
    issuer: "http://localhost:8180/realms/keycloak-learn",
    redirectUri: window.location.origin,
    clientId: "oauth-pkce-demo-client",
    responseType: "code",
    strictDiscoveryDocumentValidation: true /* all the urls retrive through issuer url should have same base url */,
    scope: "openid profile email offline_access",
}