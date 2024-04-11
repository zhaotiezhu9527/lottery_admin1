import request from '@/utils/request'

// 查询皇冠体育注单列表
export function listHgRecord(query) {
  return request({
    url: '/lottery/hgRecord/list',
    method: 'get',
    params: query
  })
}

// 查询皇冠体育注单详细
export function getHgRecord(id) {
  return request({
    url: '/lottery/hgRecord/' + id,
    method: 'get'
  })
}

// 新增皇冠体育注单
export function addHgRecord(data) {
  return request({
    url: '/lottery/hgRecord',
    method: 'post',
    data: data
  })
}

// 修改皇冠体育注单
export function updateHgRecord(data) {
  return request({
    url: '/lottery/hgRecord',
    method: 'put',
    data: data
  })
}

// 删除皇冠体育注单
export function delHgRecord(id) {
  return request({
    url: '/lottery/hgRecord/' + id,
    method: 'delete'
  })
}
