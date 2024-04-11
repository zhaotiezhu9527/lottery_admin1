import request from '@/utils/request'

// 查询公告设置列表
export function listNotice(query) {
  return request({
    url: '/lottery/notice/list',
    method: 'get',
    params: query
  })
}

// 查询公告设置详细
export function getNotice(id) {
  return request({
    url: '/lottery/notice/' + id,
    method: 'get'
  })
}

// 新增公告设置
export function addNotice(data) {
  return request({
    url: '/lottery/notice',
    method: 'post',
    data: data
  })
}

// 修改公告设置
export function updateNotice(data) {
  return request({
    url: '/lottery/notice',
    method: 'put',
    data: data
  })
}

// 删除公告设置
export function delNotice(id) {
  return request({
    url: '/lottery/notice/' + id,
    method: 'delete'
  })
}
