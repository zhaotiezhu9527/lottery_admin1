import request from '@/utils/request'

// 查询充值订单列表
export function listDeposit(query) {
  return request({
    url: '/lottery/deposit/list',
    method: 'get',
    params: query
  })
}

// 查询充值订单详细
export function getDeposit(id) {
  return request({
    url: '/lottery/deposit/' + id,
    method: 'get'
  })
}

// 新增充值订单
export function addDeposit(data) {
  return request({
    url: '/lottery/deposit',
    method: 'post',
    data: data
  })
}

// 修改充值订单
export function updateDeposit(data) {
  return request({
    url: '/lottery/deposit',
    method: 'put',
    data: data
  })
}

// 删除充值订单
export function delDeposit(id) {
  return request({
    url: '/lottery/deposit/' + id,
    method: 'delete'
  })
}
