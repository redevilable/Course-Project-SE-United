import request from '@/utils/request'

export function getTableList() {
  return request({
    url: '/v1/table/list',
    method: 'get'
  })
}

export function getTableData(tableId) {
  const params = { table_id: tableId }
  return request({
    url: '/v1/table/getdata',
    method: 'get',
    params
  })
}

export function downloadTable(tableId) {
  const params = { table_id: tableId }
  return request({
    url: '/v1/table/export',
    method: 'get',
    params,
    responseType: 'blob'
  })
}

export function saveTable(tableId, data, deleteIds) {
  const body = { table_id: tableId, data: data, delete_ids: deleteIds }
  return request({
    url: '/v1/table/save',
    method: 'post',
    data: body,
    headers: {
      'Content-Type': 'application/json'
    }
  })
}

export function sendMsg(tableId) {
  const body = { table_id: tableId }
  return request({
    url: '/v1/table/send_msg',
    method: 'post',
    data: body,
    headers: {
      'Content-Type': 'application/json'
    }
  })
}
