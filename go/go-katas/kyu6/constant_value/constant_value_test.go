package constant_value

import (
	"testing"

	. "github.com/onsi/ginkgo"
	. "github.com/onsi/gomega"
)

var _ = Describe("Test Example", func() {
	It("Should return the correct values!", func() {
		Expect(solve("a")).To(Equal(0))
		Expect(solve("bcd")).To(Equal(9))
		Expect(solve("zea")).To(Equal(26))
		Expect(solve("az")).To(Equal(26))
		Expect(solve("baz")).To(Equal(26))
		Expect(solve("aeiou")).To(Equal(0))
		Expect(solve("uaoczei")).To(Equal(29))
		Expect(solve("abababababfapeifapefijaefaepfjavnefjnfbhwyfnjsifjapnes")).To(Equal(143))
		Expect(solve("codewars")).To(Equal(37))
		Expect(solve("bup")).To(Equal(16))
	})
})

func TestBooks(t *testing.T) {
	RegisterFailHandler(Fail)
	RunSpecs(t, "constant value tests")
}
