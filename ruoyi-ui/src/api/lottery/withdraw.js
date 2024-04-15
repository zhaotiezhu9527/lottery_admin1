import request from '@/utils/request'

// 查询提现订单列表
export function listWithdraw(query) {
  return request({
    url: '/lottery/withdraw/list',
    method: 'get',
    params: query
  })
}

// 查询提现订单详细
export function getWithdraw(id) {
  return request({
    url: '/lottery/withdraw/' + id,
    method: 'get'
  })
}

// 新增提现订单
export function addWithdraw(data) {
  return request({
    url: '/lottery/withdraw',
    method: 'post',
    data: data
  })
}

// 修改提现订单
export function updateWithdraw(data) {
  return request({
    url: '/lottery/withdraw',
    method: 'put',
    data: data
  })
}

// 删除提现订单
export function delWithdraw(id) {
  return request({
    url: '/lottery/withdraw/' + id,
    method: 'delete'
  })
}

// 提现审核
export function withdrawCheck(data) {
  return request({
    url: '/lottery/withdraw/check',
    method: 'post',
    data: data
  })
}