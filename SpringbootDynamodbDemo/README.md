# springboot-dynamodb-example
Application using SpringBoot + DynamoDB


---

## Dependency (Required)

```javascript
<dependency>
	<groupId>com.amazonaws</groupId>
	<artifactId>aws-java-sdk-dynamodb</artifactId>
	<version>1.11.815</version>
</dependency>
```



## Custom IAM User Policy 

```json
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action":   [ "dynamodb:PutItem" ],
      "Resource": [ "*" ]
    },
    {
      "Effect": "Allow",
      "Action":   [ "sns:Publish" ],
      "Resource": [ "*" ]
    }
  ]
}
```

## Request JSON

```json
{
	"name":"Mishi",
	"email":"xyz@gmail.com",
	"age":30
}

```
