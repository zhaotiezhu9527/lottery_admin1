import request from '@/utils/request'

// 查询玩法管理列表
export function listLotteryPlay(query) {
  return request({
    url: '/lottery/lotteryPlay/list',
    method: 'get',
    params: query
  })
}

// 查询玩法管理详细
export function getLotteryPlay(id) {
  return request({
    url: '/lottery/lotteryPlay/' + id,
    method: 'get'
  })
}

// 新增玩法管理
export function addLotteryPlay(data) {
  return request({
    url: '/lottery/lotteryPlay',
    method: 'post',
    data: data
  })
}

// 修改玩法管理
export function updateLotteryPlay(data) {
  return request({
    url: '/lottery/lotteryPlay',
    method: 'put',
    data: data
  })
}

// 删除玩法管理
export function delLotteryPlay(id) {
  return request({
    url: '/lottery/lotteryPlay/' + id,
    method: 'delete'
  })
}
