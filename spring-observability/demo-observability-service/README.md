# Spring Observability

## How to run?
 - Run `docker compose up`
 - Access Prometheus at `localhost:9090`
 - Access Grafana at `localhost:3000`
 - Next connect the Prometheus as a data source in Grafana
 - Import the dashboard from `grafana/dashboards` folder with a specific dashboard id & attach the Prometheus data source to it.
 - Access the dashboard from the Grafana UI.

## Concepts
 - We expose `localhost:<service_port>` for prometheus metrics & map it to `host.docker.internal` for prometheus to scrape metrics.
 - Prometheus config consists of:
   - `scrape_interval` & `evaluation_interval` for scraping the metrics
   - `scrape_configs` for where to scrape the metrics from