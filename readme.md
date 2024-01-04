# Recruitment Service

Recruitment Service is an API service that helps companies analyze recruitment and implement it using the Java Spring framework.

## Installation

Start all necessary services in `docker-compose` folder:
Required: Mysql, Mongodb, Redis
Optional: Prometheus, Graphana

Use Maven [mvn] to install Recruitment Service.

```bash
mvn package
```
Or run it with Docker and docker compose
```bash
docker build -t recruitment-project:latest .

docker compose up -d
```

## Usage
```bash
mvn spring-boot:run
```

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update the tests as appropriate.

## License

[MIT](https://choosealicense.com/licenses/mit/)