### Servlet using Annotations

#### 1. Hello World

Java Servlet File - [HelloWorld.java](./src/main//java/HelloWorld.java)

Annotation -

```
@WebServlet(value = "/hello",
			initParams = {
					@WebInitParam(name="message", value="Hello World!") 
					}
			)
```

Output -

> ![hello-world-annotations](./output_images/image.png)

#### 2. Logging using Filter Class

Java Servlet File - [Logging.java](./src/main//java/Logging.java)

Annotation -

```
@WebFilter(urlPatterns = { "/*" })
```

Output -

>![init-logging](./output_images/image-1.png)

>![destroy-logging](./output_images/image-2.png)
