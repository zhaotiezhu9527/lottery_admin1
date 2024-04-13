import request from '@/utils/request'

// 获取路由
export const getRouters = () => {
  return request({
    url: '/getRouters',
    method: 'get'
  })
}

//获取未审核订单
export const getNotice = () => {
  return request({
    url: '/business/orderRecharge/getNoCheckCount',
    method: 'get'
  })
}

// 获取域名地址
export const sysParamAll = () => {
  return request({
    url: '/lottery/sysParam/all',
    method: 'get'
  })
}