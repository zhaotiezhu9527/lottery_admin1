import request from '@/utils/request'

// 查询额度转换列表
export function listEduOrder(query) {
  return request({
    url: '/lottery/eduOrder/list',
    method: 'get',
    params: query
  })
}

// 查询额度转换详细
export function getEduOrder(id) {
  return request({
    url: '/lottery/eduOrder/' + id,
    method: 'get'
  })
}

// 新增额度转换
export function addEduOrder(data) {
  return request({
    url: '/lottery/eduOrder',
    method: 'post',
    data: data
  })
}

// 修改额度转换
export function updateEduOrder(data) {
  return request({
    url: '/lottery/eduOrder',
    method: 'put',
    data: data
  })
}

// 删除额度转换
export function delEduOrder(id) {
  return request({
    url: '/lottery/eduOrder/' + id,
    method: 'delete'
  })
}
