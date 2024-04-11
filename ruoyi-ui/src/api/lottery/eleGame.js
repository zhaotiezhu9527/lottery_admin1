import request from '@/utils/request'

// 查询游戏列表列表
export function listEleGame(query) {
  return request({
    url: '/lottery/eleGame/list',
    method: 'get',
    params: query
  })
}

// 查询游戏列表详细
export function getEleGame(id) {
  return request({
    url: '/lottery/eleGame/' + id,
    method: 'get'
  })
}

// 新增游戏列表
export function addEleGame(data) {
  return request({
    url: '/lottery/eleGame',
    method: 'post',
    data: data
  })
}

// 修改游戏列表
export function updateEleGame(data) {
  return request({
    url: '/lottery/eleGame',
    method: 'put',
    data: data
  })
}

// 删除游戏列表
export function delEleGame(id) {
  return request({
    url: '/lottery/eleGame/' + id,
    method: 'delete'
  })
}
