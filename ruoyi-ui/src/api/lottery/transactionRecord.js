import request from '@/utils/request'

// 查询账变记录列表
export function listTransactionRecord(query) {
  return request({
    url: '/lottery/transactionRecord/list',
    method: 'get',
    params: query
  })
}

// 查询账变记录详细
export function getTransactionRecord(id) {
  return request({
    url: '/lottery/transactionRecord/' + id,
    method: 'get'
  })
}

// 新增账变记录
export function addTransactionRecord(data) {
  return request({
    url: '/lottery/transactionRecord',
    method: 'post',
    data: data
  })
}

// 修改账变记录
export function updateTransactionRecord(data) {
  return request({
    url: '/lottery/transactionRecord',
    method: 'put',
    data: data
  })
}

// 删除账变记录
export function delTransactionRecord(id) {
  return request({
    url: '/lottery/transactionRecord/' + id,
    method: 'delete'
  })
}
