# PortofinoLabsTest
Resolves a PortofinoLabs test.

### Run:

```
docker-compose up
```

After all containters are up, You can access by 3 links:

### Hello World!

URL:
```
http://localhost/v1/hello-world
```
Response:
```
{
  "message": "Hello World!"
}
```

### Logs

URL:
```
http://localhost/v1/helloworld/logs
```
Response:
```
{
  "endpoint": "hello-world",
  "logs": [
    {
      "ip": "172.18.0.3",
      "timestamp": "May 28, 2018 4:19:21 PM"
    },
    {
      "ip": "172.18.0.3",
      "timestamp": "May 11, 2018 4:54:54 PM"
    },
    {
      "ip": "app",
      "timestamp": "May 11, 2018 4:53:11 PM"
    },
    {
      "ip": "172.18.0.3",
      "timestamp": "May 11, 2018 5:09:24 PM"
    }
  ]
}
```

### Full Log:

URL: 
```
http://localhost/v1/logs
```

Response:
```
{
  "logset": [
    {
      "endpoint": "hello-world",
      "logs": [
        {
          "ip": "172.18.0.3",
          "timestamp": "May 28, 2018 4:19:21 PM"
        },
        {
          "ip": "172.18.0.3",
          "timestamp": "May 11, 2018 4:54:54 PM"
        },
        {
          "ip": "app",
          "timestamp": "May 11, 2018 4:53:11 PM"
        },
        {
          "ip": "172.18.0.3",
          "timestamp": "May 11, 2018 5:09:24 PM"
        }
      ]
    }
  ]
}
```
