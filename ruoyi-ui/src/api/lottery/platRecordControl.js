import request from '@/utils/request'

// 查询拉单控制列表
export function listPlatRecordControl(query) {
  return request({
    url: '/lottery/platRecordControl/list',
    method: 'get',
    params: query
  })
}

// 查询拉单控制详细
export function getPlatRecordControl(id) {
  return request({
    url: '/lottery/platRecordControl/' + id,
    method: 'get'
  })
}

// 新增拉单控制
export function addPlatRecordControl(data) {
  return request({
    url: '/lottery/platRecordControl',
    method: 'post',
    data: data
  })
}

// 修改拉单控制
export function updatePlatRecordControl(data) {
  return request({
    url: '/lottery/platRecordControl',
    method: 'put',
    data: data
  })
}

// 删除拉单控制
export function delPlatRecordControl(id) {
  return request({
    url: '/lottery/platRecordControl/' + id,
    method: 'delete'
  })
}
