import request from '@/utils/request'

// 查询系统参数列表
export function listSysParam(query) {
  return request({
    url: '/lottery/sysParam/list',
    method: 'get',
    params: query
  })
}

// 查询系统参数详细
export function getSysParam(id) {
  return request({
    url: '/lottery/sysParam/' + id,
    method: 'get'
  })
}

// 新增系统参数
export function addSysParam(data) {
  return request({
    url: '/lottery/sysParam',
    method: 'post',
    data: data
  })
}

// 修改系统参数
export function updateSysParam(data) {
  return request({
    url: '/lottery/sysParam',
    method: 'put',
    data: data
  })
}

// 删除系统参数
export function delSysParam(id) {
  return request({
    url: '/lottery/sysParam/' + id,
    method: 'delete'
  })
}
