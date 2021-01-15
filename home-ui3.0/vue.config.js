'use strict'
const path = require('path')

function resolve (dir) {
  return path.join(__dirname, dir)
}

const name = '糖果博客管理系统' // 标题

const port = process.env.port || process.env.npm_config_port || 8089 // 端口

module.exports = {
  // publicPath: 项目基础路径，这个值也可以被设置为空字符串 ('') 或是相对路径 ('./')
  publicPath: process.env.NODE_ENV === 'production' ? '/' : '/',
  // 生成的生产环境构建文件的目录名称
  outputDir: 'dist',
  // 放置生成的静态资源 (js、css、img、fonts) 的 (相对于 outputDir 的) 目录
  assetsDir: 'static',
  // 是否开启eslint代码检测, 生产环境不开启
  lintOnSave: process.env.NODE_ENV !== 'production',
  // 如果你不需要生产环境的 source map，可以将其设置为 false 以加速生产环境构建。
  productionSourceMap: false,
  devServer: {
    host: '127.0.0.1',
    open: true,
    port: port,
    proxy: {
      [process.env.VUE_APP_BASE_API]: {
        target: 'http://www.qiuaiyun.top:8080',
        changeOrigin: true,
        pathRewrite: {
          ['^' + process.env.VUE_APP_BASE_API]: ''
        }
      }
    //   '/foo': {
    //     target: 'http://www.qiuaiyun.top:8080'
    //   }
    },
    // 新版webpack检测主机名，不一致将中断访问
    disableHostCheck: true
  },
  // 配置项目别名
  configureWebpack: {
    name: name,
    resolve: {
      alias: {
        '~@': resolve('src'),
        '~@components': resolve('src/components'),
        '~@script': resolve('src/views/script')
      }
    }
  },
  // 配置项目细粒度修改
  chainWebpack: config => {
    config
      .plugin('html')
      .tap(args => {
        args[0].title = name
        return args
      })
  },
  css: {
    loaderOptions: {
      // 给 sass-loader 传递选项
      sass: {
        // @/ 是 src/ 的别名
        // 所以这里假设你有 `src/variables.sass` 这个文件
        // 注意：在 sass-loader v8 中，这个选项名是 "prependData"
        prependData: '@import "~@/assets/css/global.scss";'
      },
      // 默认情况下 `sass` 选项会同时对 `sass` 和 `scss` 语法同时生效
      // 因为 `scss` 语法在内部也是由 sass-loader 处理的
      // 但是在配置 `prependData` 选项的时候
      // `scss` 语法会要求语句结尾必须有分号，`sass` 则要求必须没有分号
      // 在这种情况下，我们可以使用 `scss` 选项，对 `scss` 语法进行单独配置
      scss: {
        prependData: '@import "~@/assets/css/global.scss";'
      },
      // 给 less-loader 传递 Less.js 相关选项
      less: {
        globalVars: {
          primary: '#fff'
        }
      }
    }
  }

}
