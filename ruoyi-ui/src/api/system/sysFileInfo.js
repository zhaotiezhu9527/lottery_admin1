import request from '@/utils/request'

// 查询文件信息列表
export function listSysFileInfo(query) {
  return request({
    url: '/system/sysFileInfo/list',
    method: 'get',
    params: query
  })
}

// 查询文件信息详细
export function getSysFileInfo(fileId) {
  return request({
    url: '/system/sysFileInfo/' + fileId,
    method: 'get'
  })
}

// 新增文件信息
export function addSysFileInfo(data) {
  return request({
    url: '/system/sysFileInfo',
    method: 'post',
    data: data
  })
}

// 修改文件信息
export function updateSysFileInfo(data) {
  return request({
    url: '/system/sysFileInfo',
    method: 'put',
    data: data
  })
}

// 删除文件信息
export function delSysFileInfo(fileId) {
  return request({
    url: '/system/sysFileInfo/' + fileId,
    method: 'delete'
  })
}
