{
  "version": "0.0.0",
  "name": "${project.id}",
  "appPath": "src/main/webapp/",
  "testPath": "src/test/javascript/spec",
  "dependencies": {
    "angular": "1.5.8",
    "angular-aria": "1.5.8",
    "angular-bootstrap": "1.3.3",
    "angular-breadcrumb": "^0.5.0",
    "angular-cache-buster": "0.4.3",
    "angular-cookies": "1.5.8",
    "angular-dynamic-locale": "0.1.32",
    "angular-i18n": "1.5.8",
    "angular-loading-bar": "0.9.0",
    "angular-resource": "1.5.8",
    "angular-sanitize": "1.5.8",
    "angular-translate": "2.11.1",
    "angular-translate-interpolation-messageformat": "2.11.1",
    "angular-translate-loader-partial": "2.11.1",
    "angular-translate-storage-cookie": "2.11.1",
    "angular-ui-router": "0.3.1",
    "json3": "3.3.2",
    "messageformat": "0.3.1",
    "ng-file-upload": "12.0.4",
    "ngInfiniteScroll": "1.3.0",
    "ngstorage": "0.3.10",
    "swagger-ui": "2.1.5",
    "jquery": "3.3.1"
  },
  "devDependencies": {
    "angular-mocks": "1.5.8"
  },
  "overrides": {
    "angular": {
      "dependencies": {
        "jquery": "1.9.0"
      }
    },
    "angular-cache-buster": {
      "dependencies": {
        "angular": "1.5.8"
      }
    },
    "angular-dynamic-locale": {
      "dependencies": {
        "angular": "1.5.8"
      }
    },
    "bootstrap": {
      "main": [
        "dist/css/bootstrap.css"
      ]
    }
  },
  "resolutions": {
    "angular": "1.5.8",
    "angular-bootstrap": "2.0.0"
  }
}
