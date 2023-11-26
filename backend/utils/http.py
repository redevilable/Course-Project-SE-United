
from flask import jsonify


def get_common_json_response(data, status=0, msg='success', code=0):
    return jsonify(
        {
            'code': code,
            'status': status,
            'data': data,
            'msg': msg,
        }
    )
