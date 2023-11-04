# Sample Angular: First App Tutorial - Angular Homes

## Steps:

1. Install node.js:

```
$ node -v
v20.9.0
$ npm -v
10.2.3
```

2. Install Angular 16.2.9:

```
npm install -g @angular/cli
npm list -g
```

3. Download the starting code
4. Run

```
npm install --force
ng serve
```

5. Create home component:

```
ng generate component home --standalone --inline-template --skip-tests
```

6. Create housing location component:

```
ng generate component housingLocation --standalone --inline-template --skip-tests
```

7. Create housing location interface:

```
ng generate interface housinglocation
```

8. Create housing service:

```
ng generate service housing --skip-tests
```

9. Create details component:

```
ng generate component details --standalone --inline-template --skip-tests
```

10. Install json-server:

```
npm install -g json-server
```

11. Watch the db.json file:

```
json-server --watch db.json
```

12. Access:

```
http://localhost:3000/locations
```
