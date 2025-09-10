import { productFeatures } from "../../data/productFeatures";

export default function DetailInfo() {
  const features = productFeatures[product?.id] ?? productFeatures.default;

  return (
    <div className="section-card mt-3">
      <h5>이 제품이 좋은 이유</h5>
      <ul>
        {/* productFeatures.js에서 가져와서 처리 */}
      </ul>

      <p className="muted small mb-0">* 사용자 모니터/발형에 따라 체감이 다를 수 있어요.</p>
    </div>
  );

}

