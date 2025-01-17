# Spring Interceptor

## Notes
 - The `order` of interceptor decides which interceptor will be executed first. The lower the order, the earlier the interceptor will be executed.
 - The `path` of interceptor decides which URL pattern will be intercepted. So if you want to make your interceptor run on a specific URL pattern, you can set the `path` attribute.