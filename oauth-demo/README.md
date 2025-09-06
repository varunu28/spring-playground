# Oauth2 Demo
This is a simple demo of OAuth2 which uses Google as the identity provider. This isn't production ready & Spring 
boot should be used for production use cases. 
Source: [OAuth2, OpenID: SSO under the hood - Daniel Garnier-Moiroux](https://www.youtube.com/watch?v=bH5PxcJzwME)

## How does E2E login work?
 - When a user tries to log in, they are redirected to Google's OAuth server
 - The user logs in and redirects to a callback URL with an authorization code
 - The authorization code is exchanged for an access token
 - The access token is used to fetch the user's profile information
 - The user is redirected to the home page with the user's profile information