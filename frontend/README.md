# React UI

## Notes for a fresh React dev
### Project initialization
Here's how I initialized this project:
```bash
npx create-react-app tabletop-track
npm i sass --save-dev
npm install --save-dev @babel/plugin-transform-private-property-in-object
npm install react-router-dom
npm install react-icons
npm audit fix --force
npm audit fix
cd tabletop-track
npm start
```
Head to the [local UI](http://localhost:3000/)

### Installing webserver
```bash
npm install -g serve
```

### Serving the app on port 3000
```bash
serve -s build
```


