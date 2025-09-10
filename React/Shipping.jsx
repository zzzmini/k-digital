export default function Shipping() {
  return (
    <div className="section-card mt-3">
      <h6 className="mt-2">배송</h6>
      <ul>
        <li>출고: 결제일로부터 <strong>1~3일</strong> (주말/공휴일 제외)</li>
        <li>배송비: <strong>3,000원</strong> / <strong>5만원 이상 무료</strong></li>
      </ul>

      <h6 className="mt-2">교환 · 반품</h6>
      <ul>
        <li>수령 후 <strong>7일 이내</strong> 미사용 제품에 한함</li>
        <li>사이즈 교환 1회 무료(왕복비 판매자 부담)</li>
        <li>단순 변심 반품: 왕복 배송비 차감 환불</li>
      </ul>

      <p className="muted small mb-0">포장/라벨 훼손 시 교환·반품이 어려울 수 있습니다.</p>
    </div>
  );
}