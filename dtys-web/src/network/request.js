import axios from 'axios'

const server = axios.create({
  // baseURL:'https://dlw1314.top/api',
  baseURL:'http://localhost:30000',
  timeout:10000,
  headers:{
    get:{
      'reqid':'dkh_music',
      'authority':'mp3.haoge500.com',
      'referer':'https://www.zz123.com/',

    },
    post:{
      'reqid':'dkh_music',
    }
  },
  withCredentials: true
})

server.interceptors.request.use(
  config => {
    return config;
  },
  error => {
    return Promise.error(error)
  }
)
server.interceptors.response.use(
  res => {
      if (res.status === 200){
        if (res.data.code === 511) {
          // 未授权调取授权接口
        } else if (res.data.code === 510) {
          // 未登录跳转登录页
        } else {
          return Promise.resolve(res)
        }
      }else {
        return Promise.reject(res)
      }

  },
  error => {
    if (error.response) {
      alert("错误状态码："+error.response.status+'\n' + "错误信息："+error.response.data.error)
      return Promise.reject(error.response)
    }
  }
)
export  default server
