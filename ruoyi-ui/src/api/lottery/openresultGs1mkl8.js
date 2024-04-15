import request from '@/utils/request'

// 查询1分快乐8列表
export function listOpenresultGs1mkl8(query) {
  return request({
    url: '/lottery/openresultGs1mkl8/list',
    method: 'get',
    params: query
  })
}

// 查询1分快乐8详细
export function getOpenresultGs1mkl8(id) {
  return request({
    url: '/lottery/openresultGs1mkl8/' + id,
    method: 'get'
  })
}

// 新增1分快乐8
export function addOpenresultGs1mkl8(data) {
  return request({
    url: '/lottery/openresultGs1mkl8',
    method: 'post',
    data: data
  })
}

// 修改1分快乐8
export function updateOpenresultGs1mkl8(data) {
  return request({
    url: '/lottery/openresultGs1mkl8',
    method: 'put',
    data: data
  })
}

// 删除1分快乐8
export function delOpenresultGs1mkl8(id) {
  return request({
    url: '/lottery/openresultGs1mkl8/' + id,
    method: 'delete'
  })
}
