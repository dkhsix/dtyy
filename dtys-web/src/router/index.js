import Vue from 'vue'
import Router from 'vue-router'
import IndexPage from '@/views/IndexPage'
import Login from '@/views/Login'
import Register from '@/views/Register.vue'
import Retrievepw from '@/views/Retrievepw.vue'
Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    {
      path: '/',
      name: 'IndexPage',
      component: IndexPage,
    },
    // {
    //   path: '/',
    //   name: 'Login',
    //   component: Login,
    // },
    // {
    //   path: '/register',
    //   name: 'Register',
    //   component: Register,
    // },
    {
      path: '/retrievepw',
      name: 'Retrievepw',
      component: Retrievepw,
    },

  ]
})
