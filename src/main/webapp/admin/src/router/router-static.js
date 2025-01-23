import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import miyao from '@/views/modules/miyao/list'
    import miyaofafang from '@/views/modules/miyaofafang/list'
    import miyaorizhi from '@/views/modules/miyaorizhi/list'
    import news from '@/views/modules/news/list'
    import xuesheng from '@/views/modules/xuesheng/list'
    import yonghu from '@/views/modules/yonghu/list'
    import dictionaryMiyao from '@/views/modules/dictionaryMiyao/list'
    import dictionaryMiyaoYesno from '@/views/modules/dictionaryMiyaoYesno/list'
    import dictionaryMiyaofafang from '@/views/modules/dictionaryMiyaofafang/list'
    import dictionaryMiyaorizhi from '@/views/modules/dictionaryMiyaorizhi/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryXuexiao from '@/views/modules/dictionaryXuexiao/list'
    import dictionaryXueyuan from '@/views/modules/dictionaryXueyuan/list'
    import dictionaryZhuanye from '@/views/modules/dictionaryZhuanye/list'
    import miyaofafangAdd from '@/views/modules/miyaofafang/add-or-update'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      },{
        path: '/miyaofafangAdd',
        name: '密钥发放',
        component: miyaofafangAdd
      }
	  
    ,{
        path: '/dictionaryMiyao',
        name: '密钥类型',
        component: dictionaryMiyao
    }
    ,{
        path: '/dictionaryMiyaoYesno',
        name: '密钥审核',
        component: dictionaryMiyaoYesno
    }
    ,{
        path: '/dictionaryMiyaofafang',
        name: '访问权限',
        component: dictionaryMiyaofafang
    }
    ,{
        path: '/dictionaryMiyaorizhi',
        name: '日志类型',
        component: dictionaryMiyaorizhi
    }
    ,{
        path: '/dictionaryNews',
        name: '公告类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionarySex',
        name: '性别',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryXuexiao',
        name: '学校',
        component: dictionaryXuexiao
    }
    ,{
        path: '/dictionaryXueyuan',
        name: '学院',
        component: dictionaryXueyuan
    }
    ,{
        path: '/dictionaryZhuanye',
        name: '专业',
        component: dictionaryZhuanye
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/miyao',
        name: '密钥',
        component: miyao
      }
    ,{
        path: '/miyaofafang',
        name: '密钥发放',
        component: miyaofafang
      }
    ,{
        path: '/miyaorizhi',
        name: '日志信息',
        component: miyaorizhi
      }
    ,{
        path: '/news',
        name: '公告信息',
        component: news
      }
    ,{
        path: '/xuesheng',
        name: '学生',
        component: xuesheng
      }
    ,{
        path: '/yonghu',
        name: '工作人员',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
