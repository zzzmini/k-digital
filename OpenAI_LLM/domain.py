shipping = {
 2025010101: [
   {"orderNo": 2025010101, "orderSeq": 0, "productNo": 1234567890, "deliveryStatus":"PROCESSING"},
   {"orderNo": 2025010101, "orderSeq": 1, "productNo": 1234567891, "deliveryStatus":"IN_DELIVERY"},
 ],
 2025010201: [
   {"orderNo": 2025010201, "orderSeq": 0, "productNo": 1234567892, "deliveryStatus":"DELIVERED"},
   {"orderNo": 2025010201, "orderSeq": 1, "productNo": 1234567893, "deliveryStatus":"PROCESSING"},
 ]
}

products = {
 1234567890: {"productNo": 1234567890, "productName": "아이폰 16 pro", "productStatus":"NORMAL"},
 1234567891: {"productNo": 1234567891, "productName": "코카콜라 30캔", "productStatus":"OUT_OF_STOCK"},
 1234567892: {"productNo": 1234567892, "productName": "프링글스 오리지널", "productStatus":"NORMAL"},
 1234567893: {"productNo": 1234567893, "productName": "삼성전자 노트북", "productStatus":"OUT_OF_STOCK"},
}

orders = {
 2025010101: {"orderNo": 2025010101, "orderStatus": "PROCESSING", "totalAmount": 50000,
    "orderList": [
         {"productNo": 1234567890, "amount": 20000},
         {"productNo": 1234567891, "amount": 30000}
     ]},
 2025010201: {"orderNo": 2025010201, "orderStatus": "CANCELLED",  "totalAmount": 100000,
     "orderList": [
         {"productNo": 1234567892, "amount": 30000},
         {"productNo": 1234567893, "amount": 70000}
     ]},
}