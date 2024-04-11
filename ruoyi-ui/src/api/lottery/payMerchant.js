import request from '@/utils/request'

// 查询商家配置列表
export function listPayMerchant(query) {
  return request({
    url: '/lottery/payMerchant/list',
    method: 'get',
    params: query
  })
}

// 查询商家配置详细
export function getPayMerchant(id) {
  return request({
    url: '/lottery/payMerchant/' + id,
    method: 'get'
  })
}

// 新增商家配置
export function addPayMerchant(data) {
  return request({
    url: '/lottery/payMerchant',
    method: 'post',
    data: data
  })
}

// 修改商家配置
export function updatePayMerchant(data) {
  return request({
    url: '/lottery/payMerchant',
    method: 'put',
    data: data
  })
}

// 删除商家配置
export function delPayMerchant(id) {
  return request({
    url: '/lottery/payMerchant/' + id,
    method: 'delete'
  })
}
