import request from '@/utils/request'

// 查询三方注单(BBIN)列表
export function listBbinRecord(query) {
  return request({
    url: '/lottery/bbinRecord/list',
    method: 'get',
    params: query
  })
}

// 查询三方注单(BBIN)详细
export function getBbinRecord(id) {
  return request({
    url: '/lottery/bbinRecord/' + id,
    method: 'get'
  })
}

// 新增三方注单(BBIN)
export function addBbinRecord(data) {
  return request({
    url: '/lottery/bbinRecord',
    method: 'post',
    data: data
  })
}

// 修改三方注单(BBIN)
export function updateBbinRecord(data) {
  return request({
    url: '/lottery/bbinRecord',
    method: 'put',
    data: data
  })
}

// 删除三方注单(BBIN)
export function delBbinRecord(id) {
  return request({
    url: '/lottery/bbinRecord/' + id,
    method: 'delete'
  })
}
