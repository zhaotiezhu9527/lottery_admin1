import request from '@/utils/request'

// 查询沙巴体育注单列表
export function listSbRecord(query) {
  return request({
    url: '/lottery/sbRecord/list',
    method: 'get',
    params: query
  })
}

// 查询沙巴体育注单详细
export function getSbRecord(id) {
  return request({
    url: '/lottery/sbRecord/' + id,
    method: 'get'
  })
}

// 新增沙巴体育注单
export function addSbRecord(data) {
  return request({
    url: '/lottery/sbRecord',
    method: 'post',
    data: data
  })
}

// 修改沙巴体育注单
export function updateSbRecord(data) {
  return request({
    url: '/lottery/sbRecord',
    method: 'put',
    data: data
  })
}

// 删除沙巴体育注单
export function delSbRecord(id) {
  return request({
    url: '/lottery/sbRecord/' + id,
    method: 'delete'
  })
}
