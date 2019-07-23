const proxy = require('http-proxy-middleware');

module.exports = function(app) {
    app.use(
            proxy('/reactApiDemo', {
                target: 'http://localhost/demo',
                changeOrigin: true
            })
    )
}