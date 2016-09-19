module.exports = {
		entry : './components/index.js',
		output : {
			path: __dirname,
			filename: 'bundle.js'
		},
		debug: true,
  	devtool: "#eval-source-map",
		module: {
			loaders: [
			          	{ test: /\.css$/, loader: "style!css" },
									{
            test: /\.jsx?$/,
            loader: 'babel-loader',
            exclude: '/node-modules/',
             query: {
      presets: [
        require.resolve('babel-preset-es2015'),
        require.resolve('babel-preset-react')
      ],
    }
        }
			          ]
		},
		resolveLoader: {
  		modulesDirectories: [
          './node_modules'
      ]
		}
}
